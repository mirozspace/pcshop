package shop.models.service;

public class URoleServiceModel extends BaseServiceModel{
	
	private String authority;

    public URoleServiceModel() {
    }

    public URoleServiceModel(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
	
}
