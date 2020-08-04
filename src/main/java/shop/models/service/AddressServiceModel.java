package shop.models.service;

public class AddressServiceModel extends BaseServiceModel{

    private String postCode;
    private String city;
    private String country;
    private String street;
    private String streetNumb;

    public AddressServiceModel() {
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
}
