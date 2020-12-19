package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.error.address.AddressIsNotExistException;
import shop.error.product.ProductIsNotExistException;
import shop.error.user.*;
import shop.models.entities.Address;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.models.service.*;
import shop.repository.AddressRepository;
import shop.repository.ProductRepository;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;
import shop.service.URoleService;
import shop.service.UserService;
import shop.tools.Tools;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final URoleRepository URoleRepository;
	private final AddressRepository addressRepository;
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	private final URoleService uRoleService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final Tools tools;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository,
			ProductRepository productRepository, ModelMapper modelMapper, URoleService uRoleService,
			URoleRepository URoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, Tools tools) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
		this.uRoleService = uRoleService;
		this.URoleRepository = URoleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.tools = tools;
	}

	@Override
	public UserServiceModel register(UserServiceModel usm) {
		User user = this.modelMapper.map(usm, User.class);
		User saved = this.userRepository.findByUsername(usm.getUsername()).orElse(null);
		addAddressToUser(usm, user);
		if (saved != null)
			throw new UserWithUsernameAlreadyExistException(
					"User with username " + saved.getUsername() + " already exists!");
		if (this.userRepository.count() == 0) {
			this.uRoleService.seedRolesToDb();
			user.setAuthorities(new HashSet<>(this.URoleRepository.findAll()));
		} else {
			user.setAuthorities(new HashSet<>(Set.of(this.URoleRepository.findByAuthority("USER").orElse(null))));
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User savedUser = null;
		try {
			savedUser = this.userRepository.saveAndFlush(user);
		} catch (Exception e) {
			throw new UserRegistrationException("Cannot register user with username " + user.getUsername());
		}
		return this.modelMapper.map(savedUser, UserServiceModel.class);
	}

	@Override
	public List<UserServiceModel> getAllUsers() {
		return this.userRepository.findAll().stream().map(e -> this.modelMapper.map(e, UserServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserServiceModel findUserByUsername(String loggedUserStr) {
		User u = this.userRepository.findByUsername(loggedUserStr).orElse(null);
		if (u == null) {
			throw new UserIsNotExistException("User is not exist!");
		}
		return this.modelMapper.map(u, UserServiceModel.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User findUser = this.userRepository.findByUsername(username).orElse(null);
		if (findUser == null) {
			throw new UsernameNotFoundException("User does not exists!");
		}
		return findUser;
	}

	@Override
	public UserServiceModel updateProfile(UserServiceModel usm) {

		if (!usm.getPassword().equals(usm.getConfirmPassword())) {
			throw new UserPasswordsNotMatchException("Password not match!");
		}
		UserServiceModel returnUser = null;
		User u = this.userRepository.findByUsername(this.tools.getLoggedUser()).orElse(null);
		if (u != null) {

			if (usm.getPassword() != null && !"".equals(usm.getPassword()) &&
					usm.getConfirmPassword()!=null && !"".equals(usm.getConfirmPassword())){
				u.setPassword(this.bCryptPasswordEncoder.encode(usm.getPassword()));
			}
			u.setFirstName(usm.getFirstName());
			u.setLastName(usm.getLastName());
			u.setPhoneNumber(usm.getPhoneNumber());
			this.userRepository.saveAndFlush(u);
			Address userAddress = u.getAddress();
			if (userAddress != null) {
				userAddress.setCountry(usm.getCountry());
				userAddress.setCity(usm.getCity());
				userAddress.setPostCode(usm.getPostCode());
				userAddress.setStreet(usm.getStreet());
				userAddress.setStreetNumb(usm.getStreetNumb());
				this.addressRepository.saveAndFlush(userAddress);
				returnUser = this.modelMapper.map(userAddress, UserServiceModel.class);
			} else {
				throw new AddressIsNotExistException("Address is not Exist (internal error)!");
			}
		} else {
			throw new UserWithUsernameAlreadyExistException("User is not Exist (internal error)!");
		}
		return returnUser;
	}

	@Override
	public List<URoleServiceModel> getAllUserRoles(String loggedUser) {
		User user = this.userRepository.findByUsername(loggedUser).orElse(null);
		if (user == null)
			throw new UserIsNotExistException(loggedUser);
		return user.getAuthorities().stream().map(r -> this.modelMapper.map(r, URoleServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public boolean removeAllProductCart(String loggedUserStr) {
		User loggedUser = this.userRepository.findByUsername(loggedUserStr).orElse(null);
		if (loggedUser == null) {
			throw new UserIsNotExistException("User is not exist!");
		}
		loggedUser.getBoughtProducts().clear();
		this.userRepository.saveAndFlush(loggedUser);
		return true;
	}

	@Override
	public boolean removeOneProductCart(String productId, String loggedUser) {
		User userFromDb = this.userRepository.findByUsername(loggedUser).orElse(null);
		if (userFromDb == null) {
			throw new UserIsNotExistException("User with name " + loggedUser + " is not exist!");
		}
		Product product = this.productRepository.findById(productId).orElse(null);
		if (product == null) {
			throw new ProductIsNotExistException("Product is not exist!");
		}
		List<Product> products = userFromDb.getBoughtProducts();
		products.remove(product);
		this.userRepository.saveAndFlush(userFromDb);
		return true;
	}

	@Override
	public boolean buyProduct(String productId, String loggedUserStr) throws UserCannotSaveException {
		Product productForBye = this.productRepository.findById(productId).orElse(null);
		User loggedUser = this.userRepository.findByUsername(loggedUserStr).orElse(null);
		if (this.isInputDataCorrect(loggedUser, productForBye)
				&& !loggedUser.getBoughtProducts().contains(productForBye)) {
			loggedUser.getBoughtProducts().add(productForBye);
			this.userRepository.saveAndFlush(loggedUser);
		} else {
			throw new UserCannotSaveException("User cannot be save!");
		}
		return true;
	}

	@Override
	public UserServiceModel findUserById(String userId) {
		User user = this.userRepository.findById(userId).orElse(null);
		if (user == null) {
			throw new UserWithThisIdNotFoundException(userId);
		}
		return this.modelMapper.map(user, UserServiceModel.class);
	}

	@Override
	public boolean deleteUserById(String userId) {
		User userForDelete = this.userRepository.findById(userId).orElse(null);
		if (userForDelete == null) {
			throw new UserIsNotExistException("User is not exist!");
		}
		userForDelete.getAuthorities().clear();
		this.userRepository.deleteById(userId);
		return true;
	}

	private void addAddressToUser(UserServiceModel userServiceModel, User user) {
		AddressServiceModel addressServiceModel = new AddressServiceModel();
		addressServiceModel.setCity(userServiceModel.getCity());
		addressServiceModel.setCountry(userServiceModel.getCountry());
		addressServiceModel.setPostCode(userServiceModel.getPostCode());
		addressServiceModel.setStreet(userServiceModel.getStreet());
		addressServiceModel.setStreetNumb(userServiceModel.getStreetNumb());
		user.setAddress(this.modelMapper.map(addressServiceModel, Address.class));
	}

	private boolean isInputDataCorrect(User loggedUser, Product productForBuy) {
		return loggedUser != null && productForBuy != null;
	}

}
