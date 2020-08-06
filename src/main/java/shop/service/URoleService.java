package shop.service;

import shop.models.entities.URole;
import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.URoleServiceModel;

import java.util.Optional;

public interface URoleService {

    /**
     * Loads all roles to db, when project is launched for first time,
     * if db is empty
     */
    void seedRolesToDb();

    /**
     * Changes role's of user
     * @param snrsm
     */
    void editUserRoles(SaveNewRolesServiceModel snrsm);

    URoleServiceModel findByAuthority (String authority);

}
