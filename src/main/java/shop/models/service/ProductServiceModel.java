package shop.models.service;

import org.springframework.web.multipart.MultipartFile;
import shop.enums.ProductCondition;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceModel extends BaseServiceModel{

    private String name;
    private String description;
    private String make;
    private String model;
    private String sku; /*Stock keeping unit*/
    private String ean; /*European article number*/
    private BigDecimal price;
    private int quantity;
    private ProductCondition productCondition;
    private MultipartFile[] photos;
    private List<String> imageUrls;
    private CategoryServiceModel category;
    private ManufacturerServiceModel manufacturer;
    private String categoryF;
    private String manufacturerF;

    public ProductServiceModel() {
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
    
    public ManufacturerServiceModel getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerServiceModel manufacturer) {
		this.manufacturer = manufacturer;
	}

	public MultipartFile[] getPhotos() {
        return photos;
    }

    public void setPhotos(MultipartFile[] photos) {
        this.photos = photos;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ProductCondition getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductCondition productCondition) {
        this.productCondition = productCondition;
    }

    public CategoryServiceModel getCategory() {
		return category;
	}

	public void setCategory(CategoryServiceModel category) {
		this.category = category;
	}

    public String getCategoryF() {
        return categoryF;
    }

    public void setCategoryF(String categoryF) {
        this.categoryF = categoryF;
    }

    public String getManufacturerF() {
        return manufacturerF;
    }

    public void setManufacturerF(String manufacturerF) {
        this.manufacturerF = manufacturerF;
    }
}
