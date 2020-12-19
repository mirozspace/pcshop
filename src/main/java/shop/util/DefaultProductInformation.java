package shop.util;

import java.math.BigDecimal;

import shop.enums.ProductCondition;

public enum DefaultProductInformation {
	
	LAPTOP_LENOVO_T440P("Lenovo T440P", "Best laptop", "Lenovo", "T440P", "00001", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", "http://stefchev.com/files/osc/product.png"),
	
	LAPTOP_HP_PAVILION_DV_7("HP Pavilion 7", "Best laptop", "Hp", "DV7", "00002", "---", new BigDecimal("35"),
			1, ProductCondition.USED, "Laptop", "HP Company", "http://stefchev.com/files/osc/product.png"),
	
	LAPTOP_LENOVO_T430("Lenovo T430", "Best laptop", "Lenovo", "T430", "00003", "---", new BigDecimal("150"),
			2, ProductCondition.USED, "Laptop", "Lenovo Company", "http://stefchev.com/files/osc/product.png"),
	
	LAPTOP_LENOVO_T450P("Lenovo ThinkPad T450P", "Best laptop", "Lenovo", "ThinkPad T450P", "00004", "---", new BigDecimal("550"),
			2, ProductCondition.USED, "Laptop", "Lenovo Company", "http://stefchev.com/files/osc/product.png"),
	
	LAPTOP_LENOVO_T450("Lenovo T450", "Best laptop", "Lenovo", "T450", "00005", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Lenovo Company", "http://stefchev.com/files/osc/product.png"),
	
	LAPTOP_LENOVO_G50_30_1T("Lenovo G50 30 1T", "Best laptop", "Lenovo", "G50 30 1T", "00006", "---", new BigDecimal("150"),
			2, ProductCondition.USED, "Laptop", "Lenovo Company", "http://stefchev.com/files/osc/product.png"),
	
	COMPUTER_DELL_TOWER_745("Dell Tower 745", "Best Computer for office", "Dell", "Tower 745", "00007", "---", new BigDecimal("59"),
			9, ProductCondition.USED, "Computer", "Dell Company", "http://stefchev.com/files/osc/product.png");
	
	private String name;
	private String description;
	private String make;
	private String model;
	private String sku;
	private String ean;
	private BigDecimal price;
	private int quantity;
	private ProductCondition productCondition;
	private String category;
	private String manufacturer;
	private String imageUrl;

	private DefaultProductInformation(String name, String description, String make, String model, String sku,
			String ean, BigDecimal price, int quantity, ProductCondition productCondition, String category,
			String manufacturer, String imageUrl) {
		
		this.name = name;
		this.description = description;
		this.make = make;
		this.model = model;
		this.sku = sku;
		this.ean = ean;
		this.price = price;
		this.quantity = quantity;
		this.productCondition = productCondition;
		this.category = category;
		this.manufacturer = manufacturer;
		this.imageUrl = imageUrl;
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductCondition getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(ProductCondition productCondition) {
		this.productCondition = productCondition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
