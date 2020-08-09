package shop.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.models.entities.Address;
import shop.models.entities.URole;
import shop.models.entities.User;
//import shop.models.service.AddressServiceModel;
import shop.models.service.UserServiceModel;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;

import java.util.*;

//import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @MockBean
    UserRepository userRepository;
    @MockBean
    UserService userService;
    @MockBean
    ModelMapper modelMapper;
    @MockBean
    URoleService uRoleService;
    @MockBean
    URoleRepository uRoleRepository;
    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    public void findUserById_whenDataIsCorrect_ShouldReturnUser() {
        User returnUser = this.getReturnedUser();
        UserServiceModel usm = this.getInputFormUserServiceModel();
        Mockito.when(this.userRepository.findById(usm.getId())).thenReturn(Optional.of(returnUser));
        UserServiceModel actual = this.userService.findUserById(usm.getId());
        Assert.assertEquals(usm.getId(), actual.getId());
    }





















    @SuppressWarnings("unused")
	private List<URole> get4RolesInList() {
        List<URole> roles = Arrays.asList(
                new URole("51ab53e5-c468-409e-8d64-ea76099a9991", "ADMIN"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9992", "MANAGER"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9993", "WORKER"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9994", "USER")
        );
        return roles;
    }

    private UserServiceModel getInputFormUserServiceModel() {
        UserServiceModel inputUser = new UserServiceModel();
        inputUser.setUsername("desito");
        inputUser.setPassword("23445f456");
        inputUser.setConfirmPassword("23445f456");
        inputUser.setEmail("desito@desito.bg");
        inputUser.setFirstName("Desislava");
        inputUser.setLastName("Ivanova");
        inputUser.setPhoneNumber("+359000000000");
        inputUser.setCountry("Bulgaria");
        inputUser.setCity("Sofia");
        inputUser.setPostCode("1000");
        inputUser.setStreet("Vitoshla");
        inputUser.setStreetNumb("1A");
        return inputUser;
    }

    private User getReturnedUser() {
        Set<URole> rolesSet = new HashSet<>(Set.of(
                new URole("51ab53e5-c468-409e-8d64-ea76099a9991", "ADMIN"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9992", "MANAGER"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9993", "WORKER"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9994", "USER")
        ));
        User returnedUser = new User();
        Address actualUserAddress = new Address();
        returnedUser.setId("39487534sdf");
        returnedUser.setUsername("desito");
        returnedUser.setPassword("23445f456");
        returnedUser.setEmail("desito@desito.bg");
        returnedUser.setFirstName("Desislava");
        returnedUser.setLastName("Ivanova");
        returnedUser.setPhoneNumber("+359000000000");
        returnedUser.setBoughtProducts(new ArrayList<>());
        actualUserAddress.setId("nfgkdfg76584js");
        actualUserAddress.setCountry("Bulgaria");
        actualUserAddress.setCity("Sofia");
        actualUserAddress.setPostCode("1000");
        actualUserAddress.setStreet("Vitoshla");
        actualUserAddress.setStreetNumb("1A");
        returnedUser.setAddress(actualUserAddress);
        returnedUser.setAuthorities(rolesSet);
        return returnedUser;
    }

    @SuppressWarnings("unused")
	private User getActualUser() {
        Set<URole> rolesSet = new HashSet<>(Set.of(
                new URole("51ab53e5-c468-409e-8d64-ea76099a9991", "ADMIN"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9992", "MANAGER"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9993", "WORKER"),
                new URole("51ab53e5-c468-409e-8d64-ea76099a9994", "USER")
        ));
        User returnedUser = new User();
        Address actualUserAddress = new Address();
        returnedUser.setId("39487534sdf");
        returnedUser.setUsername("desito");
        returnedUser.setPassword("23445f456");
        returnedUser.setEmail("desito@desito.bg");
        returnedUser.setFirstName("Desislava");
        returnedUser.setLastName("Ivanova");
        returnedUser.setPhoneNumber("+359000000000");
        returnedUser.setBoughtProducts(new ArrayList<>());
        actualUserAddress.setId("nfgkdfg76584js");
        actualUserAddress.setCountry("Bulgaria");
        actualUserAddress.setCity("Sofia");
        actualUserAddress.setPostCode("1000");
        actualUserAddress.setStreet("Vitoshla");
        actualUserAddress.setStreetNumb("1A");
        returnedUser.setAddress(actualUserAddress);
        returnedUser.setAuthorities(rolesSet);
        return returnedUser;
    }


}