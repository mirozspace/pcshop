package shop.models.service;

public class SaveNewRolesServiceModel extends BaseServiceModel{

	private String roleAdmin;
    private String roleManager;
    private String roleWorker;
    private String userId;

    public SaveNewRolesServiceModel() {
    }

    public String getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(String roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public String getRoleManager() {
        return roleManager;
    }

    public void setRoleManager(String roleManager) {
        this.roleManager = roleManager;
    }

    public String getRoleWorker() {
        return roleWorker;
    }

    public void setRoleWorker(String roleWorker) {
        this.roleWorker = roleWorker;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
