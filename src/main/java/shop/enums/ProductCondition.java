package shop.enums;

public enum ProductCondition {

    NEW ("New", "Нов"),
    USED("Used", "Втора употреба");

    private String name;
    private String nameBg;

    ProductCondition(String name, String nameBg) {
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
