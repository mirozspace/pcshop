package shop.util;

public enum DefaultCategoryInformation {

    CATEGORY_UNKNOWN("Unknown", "Unknown Category"),
    CATEGORY_LAPTOP("LAPTOP", "Laptop"),
    CATEGORY_COMPUTER("COMPUTER", "Computer"),
    CATEGORY_COMPUTER_PARTS("COMPUTER PARTS", "Computer parts"),
    CATEGORY_COMPUTER_ACCESSORIES("COMPUTER ACCESSORIES", "Computer accessories");
    
    private String name;
    private String description;

    DefaultCategoryInformation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
