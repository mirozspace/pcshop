package shop.models.bindings;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

import static shop.constants.Regex.*;

public class ManufacturerUpdateBindingModel {

    private String name;

    public ManufacturerUpdateBindingModel() {
    }

    @Length(min = 2, max = 25, message = MANUFACTURER_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = MANUFACTURER_NAME_REGEX, message = MANUFACTURER_NAME_REGEX_ERROR_MSG)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
