package shop.models.entities;

import shop.enums.ProductCondition;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private String make;
    private String model;
    private String sku;
    private String ean;
    private BigDecimal price;
    private int quantity;
    private ProductCondition productCondition;
    private List<String> imageUrls;
    private Category category;
    private Manufacturer manufacturer;

    public Product() {
    }
    
    public Product(String name, String description, String make, String model, String sku, String ean,
			BigDecimal price, int quantity, ProductCondition productCondition, Category category,
			Manufacturer manufacturer, String imageUrl) {
    	
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
    	this.imageUrls = new ArrayList<String>();
    	imageUrls.add(imageUrl);
    	
	}
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "sku")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Column(name = "ean")
    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "quamtity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "product_condition", nullable = false)
    @Enumerated(EnumType.STRING)
    public ProductCondition getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductCondition productCondition) {
        this.productCondition = productCondition;
    }

    @Column(name = "image_urls")
    @ElementCollection(targetClass = String.class)
    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

}
