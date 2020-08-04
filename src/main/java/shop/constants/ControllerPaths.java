package shop.constants;

public abstract class ControllerPaths {

    /* HOME CONTROLLER */
    public static final String GET_MAPPING_INDEX = "";
    public static final String GET_MAPPING_HOME = "/home";

    /* USER CONTROLLER */
    public static final String REQUEST_MAPPING_USER = "/user";
    //********************************************************
    public static final String GET_MAPPING_USER_PROFILE = "/profile";
    public static final String GET_MAPPING_USER_PROFILE_UPDATE = "/profile/update";
    public static final String POST_MAPPING_USER_PROFILE_UPDATE = "/profile/update";
    public static final String GET_MAPPING_USER_LOGIN = "/login";
    public static final String GET_MAPPING_USER_REGISTER = "/register";
    public static final String POST_MAPPING_USER_REGISTER = "/register";
    public static final String GET_MAPPING_PRODUCT_ADD_TO_CART = "/add-to-cart/{productId}";
    public static final String GET_MAPPING_PRODUCT_REMOVE_FROM_CART = "/remove-from-cart/{productId}";
    public static final String GET_MAPPING_USER_CART = "/cart";
    public static final String GET_MAPPING_USER_CART_FINISH = "/cart/finish";

    /* ADMIN CONTROLLER */
    public static final String REQUEST_MAPPING_ADMIN = "/admin";
    //********************************************************
    public static final String GET_MAPPING_ADMIN_USER_ALL = "/user/all";

    /* PRODUCT CONTROLLER */
    public static final String REQUEST_MAPPING_PRODUCT = "/product";
    //********************************************************
    public static final String GET_MAPPING_PRODUCT_ADD = "/add";
    public static final String POST_MAPPING_PRODUCT_ADD = "/add";
    public static final String REQUEST_MAPPING_PRODUCT_DELETE = "/delete/{productId}";
    public static final String GET_MAPPING_DELETE_ALL_PRODUCTS = "/delete/all";
    
    /* MANUFACTURER */
    public static final String REQUEST_MAPPING_MANUFACTURER = "/manufacturer";
    //********************************************************
    public static final String GET_MAPPING_MANUFACTURER_ADD = "/add";
    public static final String POST_MAPPING_MANUFACTURER_ADD = "/add";
    public static final String GET_MAPPING_MANUFACTURER_ALL = "/all";
    public static final String GET_MAPPING_MANUFACTURER_UPDATE = "/update";
    public static final String POST_MAPPING_MANUFACTURER_UPDATE = "/update";
    public static final String GET_MAPPING_MANUFACTURER_DELETE = "/delete/{manufacturerId}";
    public static final String POST_MAPPING_MANUFACTURER_SAVE = "/save/";

    /* CATEGORY CONTROLLER */
    public static final String REQUEST_MAPPING_CATEGORY = "/category";
    //********************************************************
    public static final String GET_MAPPING_CATEGORY_ADD = "/add";
    public static final String POST_MAPPING_CATEGORY_ADD = "/add";
    public static final String GET_MAPPING_CATEGORY_UPDATE = "/update";
    public static final String GET_MAPPING_CATEGORY_ALL = "/all";
    public static final String GET_MAPPING_CATEGORY_DELETE = "/delete/{categoryId}";
    public static final String POST_MAPPING_CATEGORY_SAVE = "/save/";

    /* ABOUT CONTROLLER */
    public static final String GET_MAPPING_ABOUT = "/about";

    /* FAQ CONTROLLER */
    public static final String GET_MAPPING_FAQ = "/faq";

    /* CONTACT CONTROLLER */
    public static final String GET_MAPPING_CONTACT = "/contact";

    /* DELIVERY INFORMATION CONTROLLER */
    public static final String GET_MAPPING_DELIVERY_INFORMATION = "/delivery-information";

    /* PRIVACY POLICY CONTROLLER */
    public static final String GET_MAPPING_PRIVACY_POLICY = "/privacy-policy";

    /* RETURN QUERY CONTROLLER */
    public static final String GET_MAPPING_RETURN_QUERY = "/return-query";
    public static final String POST_MAPPING_RETURN_QUERY = "/return-query";

    /* TERM AND CONDITION CONTROLLER */
    public static final String GET_MAPPING_TERM_AND_CONDITION = "/term-and-conditions";

    /* REDIRECTS */
    public static final String REDIRECT_TO_CATEGORY_ALL = "redirect:/category-all";
    public static final String REDIRECT_TO_ABOUT = "redirect:/about";
    public static final String REDIRECT_TO_RETURN_QUERY = "redirect:/return-query";
    public static final String REDIRECT_TO_HOME = "redirect:/home";
    public static final String REDIRECT_TO_LOGIN = "redirect:/user/login";
    public static final String REDIRECT_TO_PRODUCT_ADD = "redirect:/product/add";
    public static final String REDIRECT_TO_CATEGORY_ADD = "redirect:/category/add";
    public static final String REDIRECT_TO_USER_PROFILE_UPDATE = "redirect:/user/profile/update";
    public static final String REDIRECT_TO_USER_CART = "redirect:/user/cart";
    public static final String REDIRECT_TO_REGISTER = "redirect:/user/register";
    public static final String REDIRECT_TO_MANUFACTURER_ADD = "redirect:/manufacturer/add";
    public static final String REDIRECT_TO_MANUFACTURER_UPDATE = "redirect:/manufacturer/update";
    public static final String REDIRECT_TO_CATEGORY_UPDATE = "redirect:/category/update";
    //public static final String REDIRECT_TO_EDIT_USER_PROFILE = "redirect:/category/add";

    /* VIEWS */

    public static final String ADMIN_USER_ALL_VIEW = "admin/user-all";

    public static final String CATEGORY_ADD_VIEW = "category/category-add";
    public static final String CATEGORY_UPDATE_VIEW = "category/category-update";

    public static final String LOGIN_VIEW = "auth/login";
    public static final String REGISTER_VIEW = "auth/register";

    public static final String MANUFACTURER_ADD_VIEW = "manufacturer/manufacturer-add";
    public static final String MANUFACTURER_UPDATE_VIEW = "manufacturer/manufacturer-update";
    public static final String MANUFACTURER_ALL_VIEW = "manufacturer/manufacturer-all";

    public static final String PROFILE_VIEW = "profile/profile";
    public static final String PROFILE_UPDATE_VIEW = "profile/profile-update";

    public static final String PRODUCT_ADD_VIEW = "product/product-add";

    public static final String ABOUT_VIEW = "info/about";
    public static final String CONTACT_VIEW = "info/contact";
    public static final String FAQ_VIEW = "info/faq";

    public static final String RETURN_QUERY_VIEW = "infopr/return-query";
    public static final String DELIVERY_INFORMATION_VIEW = "infopr/delivery-information";

    public static final String TERM_AND_CONDITION_VIEW = "infou/term-and-conditions";
    public static final String PRIVACY_POLICY_VIEW = "infou/privacy-policy";

    public static final String HOME_VIEW = "home";
    public static final String CART_VIEW = "cart";
    public static final String STORE_VIEW = "store";

}




/*@Value("${getMappingHome}")
    public static String GET_MAPPING_HOME;*/