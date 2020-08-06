package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public void seedRolesToDb() {
		if (this.URoleRepository.count() == 0) {
			this.URoleRepository.saveAndFlush(new URole("ADMIN"));
			this.URoleRepository.saveAndFlush(new URole("MANAGER"));
			this.URoleRepository.saveAndFlush(new URole("WORKER"));
			this.URoleRepository.saveAndFlush(new URole("USER"));
		}
	}

	@Override
	public void editUserRoles(SaveNewRolesServiceModel snrsm) {
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
		}
		if (snrsm.getRoleManager().equals("1")) {
			URole roleManager = this.URoleRepository.findByAuthority("MANAGER").orElse(null);
			user.getAuthorities().add(roleManager);
		}
		if (snrsm.getRoleWorker().equals("1")) {
			URole roleWorker = this.URoleRepository.findByAuthority("WORKER").orElse(null);
			user.getAuthorities().add(roleWorker);
		}
		this.userRepository.saveAndFlush(user);
	}

    @Override
    public URoleServiceModel findByAuthority(String authority) {
		URole uRole = this.URoleRepository.findByAuthority(authority).orElse(null);
		return uRole!=null ? this.modelMapper.map(uRole, URoleServiceModel.class) : null;
    }

}
