package shop.util;

public enum DefaultManufacturerInformation {

    MANUFACTURER_UNKNOWN("Unknown Company"),
    MANUFACTURER_ACER("Acer Company"),
    MANUFACTURER_ASUS("Asus Company"),
    MANUFACTURER_LENOVO("Lenovo Company"),
    MANUFACTURER_HP("HP Company"),
    MANUFACTURER_DELL("Dell Company");

    private String name;

    DefaultManufacturerInformation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
