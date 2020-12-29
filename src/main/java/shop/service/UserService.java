package shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import shop.error.user.UserCannotSaveException;
import shop.models.service.AuthorityServiceModel;
import shop.models.service.UserServiceModel;
import java.util.List;

public interface UserService extends UserDetailsService {

	boolean buyProduct(String productId, String loggedUserStr) throws UserCannotSaveException;

    UserServiceModel register (UserServiceModel userServiceModel);

    UserServiceModel updateProfile(UserServiceModel usm);

    List<AuthorityServiceModel> getAllUserRoles(String loggedUser);

    List<UserServiceModel> getAllUsers();

    UserServiceModel findUserByUsername(String loggedUserStr);

    UserServiceModel findUserById(String userId);

    boolean removeAllProductCart(String loggedUserStr);

    boolean removeOneProductCart(String productId, String loggedUser);

	boolean deleteUserById(String userId);

}
