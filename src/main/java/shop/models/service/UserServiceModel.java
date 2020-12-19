package shop.models.service;

import java.util.List;
import java.util.Set;

public class UserServiceModel extends BaseServiceModel{

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<ProductServiceModel> buyedProducts;

    private String postCode;
    private String city;
    private String country;
    private String street;
    private String streetNumb;

    private AddressServiceModel address;
    private Set<URoleServiceModel> authorities;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<URoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<URoleServiceModel> authorities) {
        this.authorities = authorities;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumb() {
        return streetNumb;
    }

    public void setStreetNumb(String streetNumb) {
        this.streetNumb = streetNumb;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

    public List<ProductServiceModel> getBuyedProducts() {
        return buyedProducts;
    }

    public void setBoughtProducts(List<ProductServiceModel> buyedProducts) {
        this.buyedProducts = buyedProducts;
    }
}
