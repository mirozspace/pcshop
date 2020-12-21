package shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import shop.error.user.UserCannotSaveException;
import shop.models.service.URoleServiceModel;
import shop.models.service.AuthorityServiceModel;
import java.util.List;

public interface UserService extends UserDetailsService {

	boolean buyProduct(String productId, String loggedUserStr) throws UserCannotSaveException;

    AuthorityServiceModel register (AuthorityServiceModel authorityServiceModel);

    AuthorityServiceModel updateProfile(AuthorityServiceModel usm);

    List<URoleServiceModel> getAllUserRoles(String loggedUser);

    List<AuthorityServiceModel> getAllUsers();

    AuthorityServiceModel findUserByUsername(String loggedUserStr);

    AuthorityServiceModel findUserById(String userId);

    boolean removeAllProductCart(String loggedUserStr);

    boolean removeOneProductCart(String productId, String loggedUser);

	boolean deleteUserById(String userId);

}
