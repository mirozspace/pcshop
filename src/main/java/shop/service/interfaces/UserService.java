package shop.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import shop.error.UserCannotSaveException;
import shop.models.service.ProductServiceModel;
import shop.models.service.URoleServiceModel;
import shop.models.service.UserServiceModel;
import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * Product purchase method. If a product is purchased by the consumer,
     * it cannot be purchased again until the order has been completed.
     * This method adds a product to the list of purchased consumer products.
     * @param productId
     * @param loggedUserStr
     * @throws UserCannotSaveException
     */
	void buyProduct(String productId, String loggedUserStr) throws UserCannotSaveException;

    /**
     * User registration method
     * @param userServiceModel
     * @return UserServiceModel
     */
    UserServiceModel register (UserServiceModel userServiceModel);

    /**
     * Loads the page to update user information.
     * @param usm
     * @return UserServiceModel
     */
    UserServiceModel updateProfile(UserServiceModel usm);

    /**
     * Returns a list of all user roles
     * @param loggedUser
     * @return List<URoleServiceModel>
     */
    List<URoleServiceModel> getAllUserRoles(String loggedUser);

    /**
     * Returns a list of all users
     * @return List<UserServiceModel>
     */
    List<UserServiceModel> getAllUsers();

    /**
     * Finds a user by his username
     * @param loggedUserStr
     * @return UserServiceModel
     */
    UserServiceModel findUserByUsername(String loggedUserStr);

    /**
     * Finds a user by his id
     * @param userId
     * @return
     */
    UserServiceModel findUserById(String userId);

    /**
     * Remove all selected products from the user list.
     * @param loggedUserStr
     */
    void removeAllProductCart(String loggedUserStr);

    /**
     * Removes a selected product from the user's product list.
     * @param productId
     * @param loggedUser
     */
    void removeOneProductCart(String productId, String loggedUser);


    //void removeProductCart(String productId, String loggedUser);

    //List<ProductServiceModel> getAllBoughtProducts(String loggedUser);

    //UserServiceModel changeUserPassword(ChangePasswordServiceModel cpsm);


	
}
