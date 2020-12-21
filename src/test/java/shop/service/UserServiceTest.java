package shop.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.error.user.UserRegistrationException;
import shop.error.user.UserWithUsernameAlreadyExistException;
import shop.models.entities.Address;
import shop.models.entities.Authority;
import shop.models.entities.User;
import shop.models.service.AddressServiceModel;
import shop.models.service.AuthorityServiceModel;
import shop.repository.AddressRepository;
import shop.repository.ProductRepository;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;
import shop.service.impl.UserServiceImpl;
import shop.tools.Tools;

import java.util.*;

@SpringBootTest
class UserServiceTest {

    @MockBean
    UserRepository userRepository;
    @MockBean
    URoleRepository uRoleRepository;
    @MockBean
    AddressRepository addressRepository;
    @MockBean
    ProductRepository productRepository;
    @MockBean
    private Tools tools;
    @MockBean
    URoleService uRoleService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserServiceImpl userServiceImpl;

    private AuthorityServiceModel usm;
    private User user;
    private Address address;
    private List<Authority> rolesAdmin;
    private List<Authority> rolesUser;

    @Before
    public void init() {
        this.usm = this.getUserServiceModel();
        this.user = this.getUserUser();
        this.address = this.getAddress();
        this.rolesAdmin = this.getRolesAdmin();
        /*this.userServiceImpl = new UserServiceImpl(

        )*/
    }

    @Test
    public void findUserById_whenDataIsCorrect_ShouldReturnUserAdmin() {
        Mockito.when(this.userRepository.findByUsername(Mockito.anyString()))
                .thenReturn(Optional.empty());
        Mockito.when(this.userRepository.count()).thenReturn(0L);
        Mockito.when(this.uRoleRepository.findAll()).thenReturn(this.getRolesAdmin());
        System.out.println();
        User user = this.modelMapper.map(this.usm, User.class);
        User saved = this.userRepository.findByUsername(usm.getUsername()).orElse(null);
        this.addAddressToUser(usm, user);

        if (saved != null)
            throw new UserWithUsernameAlreadyExistException(
                    "User with username " + saved.getUsername() + " already exists!");

        if (this.userRepository.count() == 0) {
            this.uRoleService.seedRolesToDb();
            user.setAuthorities(new HashSet<>(this.uRoleRepository.findAll()));
        } else {
            user.setAuthorities(new HashSet<>(Set.of(this.uRoleRepository.findByAuthority("USER").orElse(null))));
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser = null;
        try {
            savedUser = this.userRepository.saveAndFlush(user);
        } catch (Exception e) {
            throw new UserRegistrationException("Cannot register user with username " + user.getUsername());
        }
        AuthorityServiceModel expected = this.modelMapper.map(savedUser, AuthorityServiceModel.class);
    }

    private void addAddressToUser(AuthorityServiceModel authorityServiceModel, User user) {
        AddressServiceModel addressServiceModel = new AddressServiceModel();
        addressServiceModel.setCity(authorityServiceModel.getCity());
        addressServiceModel.setCountry(authorityServiceModel.getCountry());
        addressServiceModel.setPostCode(authorityServiceModel.getPostCode());
        addressServiceModel.setStreet(authorityServiceModel.getStreet());
        addressServiceModel.setStreetNumb(authorityServiceModel.getStreetNumb());
        user.setAddress(this.modelMapper.map(addressServiceModel, Address.class));
    }


    private AuthorityServiceModel getUserServiceModel() {
        AuthorityServiceModel authorityServiceModel = new AuthorityServiceModel();
        authorityServiceModel.setId("shd87f687j32jkjdhf");
        authorityServiceModel.setUsername("desito");
        authorityServiceModel.setPassword("23445f456");
        authorityServiceModel.setConfirmPassword("23445f456");
        authorityServiceModel.setEmail("desito@desito.bg");
        authorityServiceModel.setFirstName("Desislava");
        authorityServiceModel.setLastName("Ivanova");
        authorityServiceModel.setPhoneNumber("+359000000000");
        authorityServiceModel.setCountry("Bulgaria");
        authorityServiceModel.setCity("Sofia");
        authorityServiceModel.setPostCode("1000");
        authorityServiceModel.setStreet("Vitoshla");
        authorityServiceModel.setStreetNumb("1A");
        return authorityServiceModel;
    }

    private User getUserAdmin() {
        User user = new User();
        user.setId("39487534sdf");
        user.setUsername("desito");
        user.setPassword("23445f456");
        user.setEmail("desito@desito.bg");
        user.setFirstName("Desislava");
        user.setLastName("Ivanova");
        user.setPhoneNumber("+359000000000");
        user.setBoughtProducts(new ArrayList<>());
        user.setAuthorities(new HashSet<Authority>(this.getRolesAdmin()));
        user.setAddress(this.getAddress());
        return user;
    }

    private User getUserUser() {
        User user = new User();
        user.setId("39487534sdf");
        user.setUsername("desito");
        user.setPassword("23445f456");
        user.setEmail("desito@desito.bg");
        user.setFirstName("Desislava");
        user.setLastName("Ivanova");
        user.setPhoneNumber("+359000000000");
        user.setBoughtProducts(new ArrayList<>());
        user.setAuthorities(new HashSet<Authority>(this.getRolesUser()));
        user.setAddress(this.getAddress());
        return user;
    }

    private List<Authority> getRolesAdmin() {
        List<Authority> roles = new ArrayList<>(Set.of(
                new Authority("51ab53e5-c468-409e-8d64-ea76099a9991", "ADMIN"),
                new Authority("51ab53e5-c468-409e-8d64-ea76099a9992", "MANAGER"),
                new Authority("51ab53e5-c468-409e-8d64-ea76099a9993", "WORKER"),
                new Authority("51ab53e5-c468-409e-8d64-ea76099a9994", "USER")
        ));
        return roles;
    }

    private HashSet<Authority> getRolesUser() {
        HashSet<Authority> roles = new HashSet<>(Set.of(
                new Authority("51ab53e5-c468-409e-8d64-ea76099a9994", "USER")
        ));
        return roles;
    }

    private Address getAddress() {
        Address address = new Address();
        address.setId("nfgkdfg76584js");
        address.setCountry("Bulgaria");
        address.setCity("Sofia");
        address.setPostCode("1000");
        address.setStreet("Vitoshla");
        address.setStreetNumb("1A");
        return address;
    }

}
