package shop.service.interfaces;

import shop.models.service.SaveNewRolesServiceModel;

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

}
