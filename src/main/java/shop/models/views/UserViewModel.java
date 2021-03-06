package shop.models.views;

import shop.models.service.AuthorityServiceModel;

import java.util.List;
import java.util.Set;

public class UserViewModel extends BaseViewModel{

	private String username;
    private String firstName;
    private String lastName;
    private String email;
    private AddressViewModel address;
	private String phoneNumber;
	private List<ProductViewModel> buyedProducts;
	private Set<AuthorityServiceModel> authorities;
	
	public UserViewModel() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressViewModel getAddress() {
		return address;
	}

	public void setAddress(AddressViewModel address) {
		this.address = address;
	}

	public List<ProductViewModel> getBuyedProducts() {
		return buyedProducts;
	}

	public void setBuyedProducts(List<ProductViewModel> buyedProducts) {
		this.buyedProducts = buyedProducts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<AuthorityServiceModel> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityServiceModel> authorities) {
		this.authorities = authorities;
	}

}
