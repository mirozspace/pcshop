package shop.models.bindings;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;
import shop.enums.ProductCondition;

import javax.validation.constraints.*;
import java.math.BigDecimal;

import static shop.constants.Regex.*;

public class ProductUpdateBindingModel extends BaseBindingModel {

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
    private String categoryF;
    private String manufacturerF;

    public ProductUpdateBindingModel() {
    }

    @Length(min = 2, max = 20, message = PRODUCT_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_NAME_REGEX, message = PRODUCT_NAME_REGEX_ERROR_MSG)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 5, max = 250, message = PRODUCT_DESCRIPTION_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_DESCRIPTION_REGEX, message = PRODUCT_DESCRIPTION_REGEX_ERROR_MSG)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Length(min = 1, max = 25, message = PRODUCT_MAKE_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_MAKE_REGEX, message = PRODUCT_MAKE_REGEX_ERROR_MSG)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Length(min = 1, max = 25, message = PRODUCT_MODEL_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_MODEL_REGEX, message = PRODUCT_MODEL_REGEX_ERROR_MSG)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Length(min = 1, max = 25, message = PRODUCT_SKU_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_SKU_REGEX, message = PRODUCT_SKU_REGEX_ERROR_MSG)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Length(min = 1, max = 25, message = PRODUCT_EAN_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_EAN_REGEX, message = PRODUCT_EAN_REGEX_ERROR_MSG)
    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    @Digits(integer = 2, fraction = 0, message = PRODUCT_QUANTITY_DIGIT_SIZE_INT_MSG)
    @DecimalMin(value = "1", message = PRODUCT_QUANTITY_MIN_ERROR_MSG)
    @DecimalMax(value = "10", message = PRODUCT_QUANTITY_MAX_ERROR_MSG)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Digits(integer = 5, fraction = 2, message = PRODUCT_PRICE_DIGIT_SIZE_INT_MSG)
    @DecimalMin(value = "0.00", message = PRODUCT_PRICE_MIN_ERROR_MSG)
    @DecimalMax(value = "5000.00" , message = PRODUCT_PRICE_MAX_ERROR_MSG)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = PRODUCT_CONDITION_MSG) //security!
    public ProductCondition getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductCondition productCondition) {
        this.productCondition = productCondition;
    }

    @Length(min = 2, max = 25, message = CATEGORY_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = CATEGORY_NAME_REGEX, message = CATEGORY_NAME_REGEX_ERROR_MSG)
    public String getCategoryF() {
        return categoryF;
    }

    public void setCategoryF(String categoryF) {
        this.categoryF = categoryF;
    }

    @Length(min = 1, max = 25, message = MANUFACTURER_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = MANUFACTURER_NAME_REGEX, message = MANUFACTURER_NAME_REGEX_ERROR_MSG)
    public String getManufacturerF() {
        return manufacturerF;
    }

    public void setManufacturerF(String manufacturerF) {
        this.manufacturerF = manufacturerF;
    }

	public MultipartFile[] getPhotos() {
		return photos;
	}

	public void setPhotos(MultipartFile[] photos) {
		this.photos = photos;
	}
    


}
