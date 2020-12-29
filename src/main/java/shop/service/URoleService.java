package shop.service;

import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.AuthorityServiceModel;


public interface URoleService {

    boolean seedRolesToDb();

    boolean editUserRoles(SaveNewRolesServiceModel snrsm);

    AuthorityServiceModel findByAuthority (String authority);

}
