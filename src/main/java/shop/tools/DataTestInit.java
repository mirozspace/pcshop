package shop.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.models.service.UserServiceModel;
import shop.service.UserService;

//import javax.annotation.PostConstruct;

@Component
public class DataTestInit {

    private final UserService userService;

    @Autowired
    public DataTestInit(UserService userService) {
        this.userService = userService;
    }

    //@PostConstruct
    @SuppressWarnings("unused")
	private void getInputUser() {
        UserServiceModel inputUser = new UserServiceModel();
        inputUser.setUsername("admin");
        inputUser.setPassword("5zh317aq");
        inputUser.setConfirmPassword("5zh317aq");
        inputUser.setEmail("admin@admin.admin");
        inputUser.setFirstName("Admin");
        inputUser.setLastName("Admin");
        inputUser.setPhoneNumber("+359888381666");
        inputUser.setCountry("Bulgaria");
        inputUser.setCity("Sofia");
        inputUser.setPostCode("1000");
        inputUser.setStreet("Vitoshka");
        inputUser.setStreetNumb("10");
        this.userService.register(inputUser);
    }
}
