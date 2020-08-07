package shop.service;

import shop.models.entities.URole;
import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.URoleServiceModel;

import java.util.Optional;

public interface URoleService {

    boolean seedRolesToDb();

    boolean editUserRoles(SaveNewRolesServiceModel snrsm);

    URoleServiceModel findByAuthority (String authority);

}
