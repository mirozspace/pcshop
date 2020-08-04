package shop.models.bindings;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

import static shop.constants.Regex.*;

public class ReturnQueryBindingModel {

    private String sku;
    private String ean;
    private String productName;
    private String description;

    public ReturnQueryBindingModel() {
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

    @Length(min = 1, max = 25, message = PRODUCT_NAME_REGEX)
    @Pattern(regexp = PRODUCT_NAME_REGEX, message = PRODUCT_NAME_REGEX_ERROR_MSG)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Length(min = 1, max = 25, message = PRODUCT_DESCRIPTION_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PRODUCT_DESCRIPTION_REGEX, message = PRODUCT_DESCRIPTION_REGEX_ERROR_MSG)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
