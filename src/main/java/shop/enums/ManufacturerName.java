package shop.enums;

public enum ManufacturerName {

    DELL("Dell", "Dell"),
    LENOVO("Lenovo", "Леново"),
    HP("Hp", "HP");

    private String name;
    private String nameBg;

    ManufacturerName(String name, String nameBg) {
        this.name = name;
        this.nameBg = nameBg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameBg() {
        return nameBg;
    }

    public void setNameBg(String nameBg) {
        this.nameBg = nameBg;
    }

}
