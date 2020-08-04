package shop.models.bindings;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

import static shop.constants.Regex.*;

public class CategoryUpdateBindingModel {

    private String name;
    private String description;

    public CategoryUpdateBindingModel() {
    }

    @Length(min = 2, max = 15, message = CATEGORY_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = CATEGORY_NAME_REGEX, message = CATEGORY_NAME_REGEX_ERROR_MSG)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 5, max = 250, message = CATEGORY_DESCRIPTION_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = CATEGORY_DESCRIPTION_REGEX, message = CATEGORY_DESCRIPTION_REGEX_ERROR_MSG)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
