package shop.models.bindings;

import javax.validation.constraints.Pattern;

import static shop.constants.Regex.*;

public class SaveNewRolesBindingModel {

    private String roleAdmin = "0";
    private String roleManager = "0";
    private String roleWorker = "0";
    private String userId;

    public SaveNewRolesBindingModel() {
    }

    @Pattern(regexp = INPUT_REGEX_CHECK_BUTTON, message = INPUT_REGEX_CHECK_BUTTON_ERROR_MSG)
    public String getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(String roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    @Pattern(regexp = INPUT_REGEX_CHECK_BUTTON, message = INPUT_REGEX_CHECK_BUTTON_ERROR_MSG)
    public String getRoleManager() {
        return roleManager;
    }

    public void setRoleManager(String roleManager) {
        this.roleManager = roleManager;
    }

    @Pattern(regexp = INPUT_REGEX_CHECK_BUTTON, message = INPUT_REGEX_CHECK_BUTTON_ERROR_MSG)
    public String getRoleWorker() {
        return roleWorker;
    }

    public void setRoleWorker(String roleWorker) {
        this.roleWorker = roleWorker;
    }

    @Pattern(regexp = TEXT_REGEX, message = TEXT_REGEX_ERROR_MSG)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
