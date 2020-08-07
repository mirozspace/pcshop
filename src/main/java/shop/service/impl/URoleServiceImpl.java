package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.role.URoleIsNotExistException;
import shop.error.user.UserIsNotExistException;
import shop.models.entities.URole;
import shop.models.entities.User;
import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.URoleServiceModel;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;
import shop.service.URoleService;

@Service
public class URoleServiceImpl implements URoleService {

	private final URoleRepository URoleRepository;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public URoleServiceImpl(URoleRepository URoleRepository, UserRepository userRepository,
							ModelMapper modelMapper) {
		this.URoleRepository = URoleRepository;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean seedRolesToDb() {
		if (this.URoleRepository.count() == 0) {
			this.URoleRepository.saveAndFlush(new URole("ADMIN"));
			this.URoleRepository.saveAndFlush(new URole("MANAGER"));
			this.URoleRepository.saveAndFlush(new URole("WORKER"));
			this.URoleRepository.saveAndFlush(new URole("USER"));
			return true;
		}
		return false;
	}

	@Override
	public boolean editUserRoles(SaveNewRolesServiceModel snrsm) {
		boolean isHasChange = false;
		User user = this.userRepository.findById(snrsm.getId()).orElse(null);
		if (user == null) {
			throw new UserIsNotExistException("User is not Exist!");
		}
		user.getAuthorities().clear();
		URole roleUser = this.URoleRepository.findByAuthority("USER").orElse(null);
		user.getAuthorities().add(roleUser);

		if (snrsm.getRoleAdmin().equals("1")) {
			URole roleAdmin = this.URoleRepository.findByAuthority("ADMIN").orElse(null);
			user.getAuthorities().add(roleAdmin);
			isHasChange = true;
		}
		if (snrsm.getRoleManager().equals("1")) {
			URole roleManager = this.URoleRepository.findByAuthority("MANAGER").orElse(null);
			user.getAuthorities().add(roleManager);
			isHasChange = true;
		}
		if (snrsm.getRoleWorker().equals("1")) {
			URole roleWorker = this.URoleRepository.findByAuthority("WORKER").orElse(null);
			user.getAuthorities().add(roleWorker);
			isHasChange = true;
		}
		this.userRepository.saveAndFlush(user);
		return isHasChange;
	}

    @Override
    public URoleServiceModel findByAuthority(String authority) {
		if(authority == null){
			throw new URoleIsNotExistException("URole is not exist!");
		}
		URole uRole = this.URoleRepository.findByAuthority(authority).orElse(null);
		if (uRole == null){
			throw new URoleIsNotExistException("User role is not exist!");
		}
		return this.modelMapper.map(uRole, URoleServiceModel.class);
    }

}
