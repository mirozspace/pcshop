package shop.models.bindings;

import org.hibernate.validator.constraints.Length;
import shop.constants.Regex;
import javax.validation.constraints.Pattern;
import static shop.constants.Regex.*;

public class UserProfileUpdateBindingModel {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private String postCode;
    private String city;
    private String country;
    private String street;
    private String streetNumb;
    
    private String password;
    private String confirmPassword;

    public UserProfileUpdateBindingModel() {
    }

    @Length(min = 2, max = 20, message = USERNAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = USERNAME_REGEX, message = USERNAME_REGEX_ERROR_MSG)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 1, max = 35, message = FIRST_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = FIRST_NAME_REGEX, message = FIRST_NAME_REGEX_ERROR_MSG)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Length(min = 1, max = 35, message = LAST_NAME_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = LAST_NAME_REGEX, message = LAST_NAME_REGEX_ERROR_MSG)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Length(min = 5, max = 50, message = EMAIL_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = EMAIL_REGEX, message = EMAIL_REGEX_ERROR_MSG)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //@Length(min = 6, max = 12, message = PHONE_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PHONE_REGEX, message = PHONE_REGEX_ERROR_MSG)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Length(min = 1, max = 8, message = POST_CODE_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = POST_CODE_REGEX, message = POST_CODE_REGEX_ERROR_MSG)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Length(min = 2, max = 35, message = Regex.CITY_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = CITY_REGEX, message = CITY_REGEX_ERROR_MSG)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Length(min = 2, max = 35, message = COUNTRY_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = COUNTRY_REGEX, message = COUNTRY_REGEX_ERROR_MSG)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Length(min = 2, max = 70, message = STREET_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = STREET_REGEX, message = STREET_REGEX_ERROR_MSG)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Length(min = 2, max = 70, message = STREET_NUMBER_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = STREET_NUMBER_REGEX, message = STREET_NUMBER_REGEX_ERROR_MSG)
    public String getStreetNumb() {
        return streetNumb;
    }

    public void setStreetNumb(String streetNumb) {
        this.streetNumb = streetNumb;
    }

    @Length(min = 8, max = 20, message = PASSWORD_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_REGEX_ERROR_MSG)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    @Length(min = 8, max = 20, message = PASSWORD_MIN_MAX_ERROR_MSG)
    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_REGEX_ERROR_MSG)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
    
}
