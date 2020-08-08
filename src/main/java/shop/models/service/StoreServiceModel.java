package shop.models.service;

import shop.models.entities.Address;

public class StoreServiceModel extends BaseServiceModel{

    private String name;
    private String owners;
    private Address address;
    private String email;
    private String phone;

    public StoreServiceModel() {
    }
    
    public StoreServiceModel(String name, String owners, Address address, String email, String phone) {
        this.name = name;
        this.owners = owners;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
