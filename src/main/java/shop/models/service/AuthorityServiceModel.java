package shop.models.service;

public class AuthorityServiceModel extends BaseServiceModel{
	
	private String authority;

    public AuthorityServiceModel() {
    }

    public AuthorityServiceModel(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
	
}
