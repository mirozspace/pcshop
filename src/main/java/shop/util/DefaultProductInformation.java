package shop.util;

import java.math.BigDecimal;

import shop.enums.ProductCondition;

import static shop.constants.FilePaths.DEFAULT_IMAGE_PRODUCT;

public enum DefaultProductInformation {


	LAPTOP_1("Laptop", "Description1", "Make1", "Model1", "00001", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_2("Laptop", "Description2", "Make2", "Model2", "00002", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_3("Laptop", "Description3", "Make3", "Model3", "00003", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_4("Laptop", "Description4", "Make4", "Model4", "00004", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_5("Laptop", "Description5", "Make5", "Model5", "00005", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_6("Laptop", "Description6", "Make6", "Model6", "00006", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_7("Laptop", "Description7", "Make7", "Model7", "00007", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_8("Laptop", "Description8", "Make8", "Model8", "00008", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT),

	LAPTOP_9("Laptop", "Description9", "Make9", "Model9", "00009", "---", new BigDecimal("220"),
			2, ProductCondition.USED, "Laptop", "Dell Company", DEFAULT_IMAGE_PRODUCT);

	
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

	DefaultProductInformation(String name, String description, String make, String model, String sku, String ean, BigDecimal price, int quantity, ProductCondition productCondition, String category, String manufacturer, String imageUrl) {
		
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
