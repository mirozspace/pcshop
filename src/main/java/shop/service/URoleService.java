package shop.service;

import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.URoleServiceModel;


public interface URoleService {

    boolean seedRolesToDb();

    boolean editUserRoles(SaveNewRolesServiceModel snrsm);

    URoleServiceModel findByAuthority (String authority);

}
