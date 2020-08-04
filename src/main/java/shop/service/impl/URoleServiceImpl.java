package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.UserIsNotExistException;
import shop.models.entities.URole;
import shop.models.entities.User;
import shop.models.service.SaveNewRolesServiceModel;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;
import shop.service.interfaces.URoleService;

@Service
public class URoleServiceImpl implements URoleService {

	private final URoleRepository URoleRepository;
	private final UserRepository userRepository;

	@Autowired
	public URoleServiceImpl(URoleRepository URoleRepository, UserRepository userRepository) {
		this.URoleRepository = URoleRepository;
		this.userRepository = userRepository;
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

}
