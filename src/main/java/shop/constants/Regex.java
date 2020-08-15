package shop.constants;

public abstract class Regex {

    /* BASE REGEX */
    public static final String TEXT_REGEX = "^[a-zA-Z0-9\\s+\\,\\.\\!\\\"-_]+$";
    public static final String TEXT_REGEX_ERROR_MSG = "Is not a text!";
    public static final String INPUT_REGEX_CHECK_BUTTON = "0|1";
    public static final String INPUT_REGEX_CHECK_BUTTON_ERROR_MSG = "Input value is not correct!";


	/*USERNAME ********************************************************************************************* */
    public static final String USERNAME_REGEX = TEXT_REGEX;
    public static final String USERNAME_REGEX_ERROR_MSG = "Username must contains only lettes and digits!";
    public static final String USERNAME_MIN_MAX_ERROR_MSG = "Username is not in range (2 - 20)";
    /*PASSWORD ********************************************************************************************* */
    //public static final String PASSWORD_REGEX = "\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\"";
    public static final String PASSWORD_REGEX = "^[a-zA-Z0-9-\\/.^&*_!@%+>)(]+$";
    public static final String PASSWORD_REGEX_ERROR_MSG = "Minimum eight characters, at least one uppercase letter, "
    		+ "one lowercase letter, one number and one special character!";
    public static final String PASSWORD_MIN_MAX_ERROR_MSG = "Password is not in range (8 - 20)!";
    /*EMAIL ************************************************************************************************ */
    public static final String EMAIL_REGEX 
    	= "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?" +
            "(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    public static final String EMAIL_REGEX_ERROR_MSG = "Email is not valid!";
    public static final String EMAIL_MIN_MAX_ERROR_MSG = "Email is not in range (6 - 35)!";
    /*FIRST NAME ******************************************************************************************* */
    public static final String FIRST_NAME_REGEX = "^[a-zA-Z]+$";
    public static final String FIRST_NAME_REGEX_ERROR_MSG = "First name must be only letters and digits!";
    public static final String FIRST_NAME_MIN_MAX_ERROR_MSG = "Username is not in range! (2 - 35)";
    /*LAST NAME ******************************************************************************************** */
    public static final String LAST_NAME_REGEX = "^[a-zA-Z0-9]+$";
    public static final String LAST_NAME_REGEX_ERROR_MSG = "Last name must be only letters and digits!";
    public static final String LAST_NAME_MIN_MAX_ERROR_MSG = "Is not correct name (2 - 35).";
    /*LAST NAME ******************************************************************************************** */
    public static final String PHONE_REGEX = "^[0-9+]+{1,20}$";
    public static final String PHONE_REGEX_ERROR_MSG 
    	= "Phone must contains only digits and sing plus, and 1 to 12 symbols!";
    /*POST CODE ******************************************************************************************** */
    public static final String POST_CODE_REGEX = "^[0-9]+$";
    public static final String POST_CODE_REGEX_ERROR_MSG = "Post code must contains only digits!";
    public static final String POST_CODE_MIN_MAX_ERROR_MSG = "Post code is not in range (1 - 10)!";
    /*CITY ************************************************************************************************* */
    public static final String CITY_REGEX = "^[a-zA-Z]+$";
    public static final String CITY_REGEX_ERROR_MSG = "City must contains only letters!";
    public static final String CITY_MIN_MAX_ERROR_MSG = "City is not in range (2-35)!.";
    /*COUNTRY ********************************************************************************************** */
    public static final String COUNTRY_REGEX = "^[a-zA-Z]+$";
    public static final String COUNTRY_REGEX_ERROR_MSG = "City must contains only letters!";
    public static final String COUNTRY_MIN_MAX_ERROR_MSG = "Country is not in range (2-35).";
    /*STREET *********************************************************************************************** */
    public static final String STREET_REGEX = TEXT_REGEX;
    public static final String STREET_REGEX_ERROR_MSG = "Street must contains only letters!";
    public static final String STREET_MIN_MAX_ERROR_MSG = "Street is not correct (2-70).";
    /*STREET NUMBER **************************************************************************************** */
    public static final String STREET_NUMBER_REGEX = "^[0-9a-zA-z ]+$";
    public static final String STREET_NUMBER_REGEX_ERROR_MSG 
    	= "Street number must contains only digits and sing plus, and 1 to 3 symbols!";
    public static final String STREET_NUMBER_MIN_MAX_ERROR_MSG = "Street is not correct (1-3 symbols)!";
    /* CATEGORY NAME **************************************************************************************** */
    public static final String CATEGORY_NAME_REGEX = TEXT_REGEX;
    public static final String CATEGORY_NAME_REGEX_ERROR_MSG = "Category name can contains only letters, digits and white spaces!";
    public static final String CATEGORY_NAME_MIN_MAX_ERROR_MSG = "Category name is not correct (2-15).";
    /* CATEGORY DESCRIPTION **************************************************************************************** */
    public static final String CATEGORY_DESCRIPTION_REGEX = TEXT_REGEX;
    public static final String CATEGORY_DESCRIPTION_REGEX_ERROR_MSG = "Category name can contains only letters, digits and white spaces!";
    public static final String CATEGORY_DESCRIPTION_MIN_MAX_ERROR_MSG = "Category description length is not correct (5-250).";
    /*PRODUCT NAME **************************************************************************************** */
    public static final String PRODUCT_NAME_REGEX = TEXT_REGEX;
    public static final String PRODUCT_NAME_REGEX_ERROR_MSG =
            "Product name can contains only text and digits!";
    public static final String PRODUCT_NAME_MIN_MAX_ERROR_MSG = "Product length is not in range (2 - 20)!";
    /*PRODUCT DESCRIPTION **************************************************************************************** */
    public static final String PRODUCT_DESCRIPTION_REGEX = TEXT_REGEX;
    public static final String PRODUCT_DESCRIPTION_REGEX_ERROR_MSG = "Category name can contains only text and digits!";
    public static final String PRODUCT_DESCRIPTION_MIN_MAX_ERROR_MSG = "Category length is not in range (2 - 250)!";
    /*PRODUCT MAKE **************************************************************************************** */
    public static final String PRODUCT_MAKE_REGEX = TEXT_REGEX;
    public static final String PRODUCT_MAKE_REGEX_ERROR_MSG =
            "Make can contains only text and digits!";
    public static final String PRODUCT_MAKE_MIN_MAX_ERROR_MSG =
            "Make length is not in range (1 - 25)!";
    /*PRODUCT MODEL **************************************************************************************** */
    public static final String PRODUCT_MODEL_REGEX = TEXT_REGEX;
    public static final String PRODUCT_MODEL_REGEX_ERROR_MSG = "Model can contains only text and digits!";
    public static final String PRODUCT_MODEL_MIN_MAX_ERROR_MSG = "Make length is not in range (1 - 25)!";
    /*SKU **************************************************************************************** */
    public static final String PRODUCT_SKU_REGEX = "^[A-Za-z0-9 ]+$";
    public static final String PRODUCT_SKU_REGEX_ERROR_MSG = "SKU can contains only text and digits!";
    public static final String PRODUCT_SKU_MIN_MAX_ERROR_MSG = "SKU length is not in range (1 - 25)!";
    /*EAN **************************************************************************************** */
    public static final String PRODUCT_EAN_REGEX = "^[A-Za-z0-9 ]+$";
    public static final String PRODUCT_EAN_REGEX_ERROR_MSG = "EAN can contains only text and digits!";
    public static final String PRODUCT_EAN_MIN_MAX_ERROR_MSG = "EAN length is not in range (1 - 25)!";
    /*QUANTITY **************************************************************************************** */
    public static final String PRODUCT_QUANTITY_DIGIT_SIZE_INT_MSG = "Length of value is not in range (1 - 2)!";
    public static final String PRODUCT_QUANTITY_MIN_ERROR_MSG = "Quantity is not in correct (min 1).";
    public static final String PRODUCT_QUANTITY_MAX_ERROR_MSG = "Quantity is not in correct (max 10).";
    /*PRICE **************************************************************************************** */
    public static final String PRODUCT_PRICE_DIGIT_SIZE_INT_MSG = "Length of value is not in range (1 - 5 .2)!";
    public static final String PRODUCT_PRICE_MIN_ERROR_MSG = "Price is not in correct (min 0.00).";
    public static final String PRODUCT_PRICE_MAX_ERROR_MSG = "Price is not in correct (max 10000.00).";
    /* PRODUCT CONDITION **************************************************************************************** */
    public static final String PRODUCT_CONDITION_MSG = "Product condition cannot be Null!";
    /* PRODUCT CONDITION **************************************************************************************** */
    public static final String MANUFACTURER_NAME_REGEX = TEXT_REGEX;
    public static final String MANUFACTURER_NAME_REGEX_ERROR_MSG = "Manufacturer can contains only text and digits!";
    public static final String MANUFACTURER_NAME_MIN_MAX_ERROR_MSG = "Manufacturer length is not in range (1 - 25)!";

}
