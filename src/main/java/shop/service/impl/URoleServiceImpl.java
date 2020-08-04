package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.UserIsNotExistException;
import shop.models.entities.URole;
import shop.models.entities.User;
import shop.models.service.SaveNewRolesServiceModel;
import shop.repository.RoleRepository;
import shop.repository.UserRepository;
import shop.service.interfaces.URoleService;

@Service
public class URoleServiceImpl implements URoleService {

	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	@Autowired
	public URoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void seedRolesToDb() {
		if (this.roleRepository.count() == 0) {
			this.roleRepository.saveAndFlush(new URole("ADMIN"));
			this.roleRepository.saveAndFlush(new URole("MANAGER"));
			this.roleRepository.saveAndFlush(new URole("WORKER"));
			this.roleRepository.saveAndFlush(new URole("USER"));
		}
	}

	@Override
	public void editUserRoles(SaveNewRolesServiceModel snrsm) {
		User user = this.userRepository.findById(snrsm.getId()).orElse(null);
		if (user == null) {
			throw new UserIsNotExistException("User is not Exist!");
		}
		user.getAuthorities().clear();

		URole roleUser = this.roleRepository.findByAuthority("USER").orElse(null);
		user.getAuthorities().add(roleUser);

		if (snrsm.getRoleAdmin().equals("1")) {
			URole roleAdmin = this.roleRepository.findByAuthority("ADMIN").orElse(null);
			user.getAuthorities().add(roleAdmin);
		}
		if (snrsm.getRoleManager().equals("1")) {
			URole roleManager = this.roleRepository.findByAuthority("MANAGER").orElse(null);
			user.getAuthorities().add(roleManager);
		}
		if (snrsm.getRoleWorker().equals("1")) {
			URole roleWorker = this.roleRepository.findByAuthority("WORKER").orElse(null);
			user.getAuthorities().add(roleWorker);
		}
		this.userRepository.saveAndFlush(user);
	}

}
