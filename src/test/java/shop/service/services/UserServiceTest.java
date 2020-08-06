package shop.service.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.error.UserIsNotExistException;
import shop.error.UserWithThisIdNotFoundException;
import shop.models.entities.URole;
import shop.models.entities.User;
import shop.models.service.URoleServiceModel;
import shop.models.service.UserServiceModel;
import shop.repository.UserRepository;
import shop.service.URoleService;
import shop.service.UserService;
import shop.service.base.BaseTestService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends BaseTestService {

    @MockBean
    UserRepository userRepository;
    @MockBean
    URoleService uRoleService;
    private final ModelMapper modelMapper;
    private User user;
    private User user2;
    private UserServiceModel userServiceModel;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceTest(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected void beforeEach() {
        this.user = this.getUser();
        this.user2 = this.getUser2();
    }

    @Test
    void findUserById_whenValidId_shouldReturnUser() {
        Mockito.when(this.userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        UserServiceModel userModel = this.userService.findUserById(user.getId());
        Assert.assertEquals(user.getFirstName(), userModel.getFirstName());
        Assert.assertEquals(user.getLastName(), userModel.getLastName());
        Assert.assertEquals(user.getEmail(), userModel.getEmail());
    }

    @Test
    void findUserById_whenInvalidId_shouldThrowException() {
        String id = "123";
        Mockito.when(this.userRepository.findById("2")).thenReturn(Optional.empty());
        assertThrows(UserWithThisIdNotFoundException.class, () -> this.userService.findUserById(id));
    }

    @Test
    void findUserByUsername_whenValidUsername_shouldReturnUser() {
        Mockito.when(this.userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        Assert.assertEquals(user.getFirstName(),
                this.userService.findUserByUsername(this.user.getUsername()).getFirstName());
    }

    @Test
    void findUserByUsername_whenInvalidUsername_shouldThrowException() {
        String username = "Desimira";
        Mockito.when(this.userRepository.findByUsername(username)).thenReturn(Optional.empty());
        assertThrows(UserIsNotExistException.class, () -> this.userService.findUserByUsername(username));
    }

    @Test
    void findAllUsers_withCorrectData_shouldReturnCorrect() {
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        Mockito.when(this.userRepository.findAll()).thenReturn(users);
        Assert.assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    public void findAllUsers_withNoUsers_shouldReturnCorrect() {
        List<User> users = new ArrayList<>();
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assert.assertEquals(0, userService.getAllUsers().size());
    }

    @Test
    void setUserRole_whenUserExistsAndRollValid_ShouldReturnCorrect() {
        String id = "jhadsg672324";
        User user = new User();
        user.setId(id);
        user.setAuthorities(new HashSet<>());
        user.getAuthorities().add(new URole("ADMIN"));
        Mockito.when(this.userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        URoleServiceModel role = new URoleServiceModel();
        role.setAuthority("ADMIN");
        Mockito.when(this.uRoleService.findByAuthority("ADMIN")).thenReturn(role);
        Assert.assertEquals("ADMIN", role.getAuthority());
    }

    @Test
    void register_whenAllIsValid_shouldSave() {

        UserServiceModel userServiceModel = new UserServiceModel();
        URoleServiceModel uRoleServiceModel = new URoleServiceModel();
        uRoleServiceModel.setAuthority("ADMIN");

        userServiceModel.setUsername("desito");
        userServiceModel.setFirstName("Desislava");
        userServiceModel.setLastName("Ivanova");
        userServiceModel.setEmail("desito@desito.bg");
        userServiceModel.setPassword("shdg876dKJ");
        userServiceModel.setConfirmPassword("1aA#111");
        userServiceModel.setAuthorities(new HashSet<>());


        User user = new User();
        URole uRole = new URole();
        uRole.setAuthority("ADMIN");

        user.setUsername(userServiceModel.getUsername());
        user.setFirstName(userServiceModel.getFirstName());
        user.setLastName(userServiceModel.getLastName());
        user.setEmail(userServiceModel.getEmail());
        user.setPassword(userServiceModel.getPassword());
        Set<URole> roles = new HashSet<>();
        roles.add(uRole);
        user.setAuthorities(roles);

        Mockito.when(this.userRepository.count()).thenReturn(1L);
        Mockito.when(this.uRoleService.findByAuthority("ADMIN")).thenReturn(uRoleServiceModel);
        Mockito.when(this.modelMapper.map(userServiceModel, User.class)).thenReturn(user);
        userService.register(userServiceModel);
        Assert.assertEquals(userServiceModel.getUsername(), user.getUsername());

    }
























    private User getUser(){
        User user = new User();
        user.setUsername("desito");
        user.setFirstName("Desislava");
        user.setLastName("desislavova");
        user.setEmail("desito@desito.bg");
        user.setPassword("5326sd1j");
        user.setId("jhadsg672324");
        return user;
    }

    private User getUser2(){
        User user2 = new User();
        user2.setUsername("kremenka");
        user2.setFirstName("Kremena");
        user2.setLastName("Kremenova");
        user2.setEmail("kremito@desito.bg");
        user2.setPassword("53236sd1j");
        user2.setId("jhasdff672324");
        return user2;
    }

}