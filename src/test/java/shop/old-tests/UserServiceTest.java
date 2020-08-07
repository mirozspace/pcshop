/*package shop.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import shop.models.entities.User;
import shop.models.service.AddressServiceModel;
import shop.models.service.ProductServiceModel;
import shop.models.service.UserServiceModel;
import shop.repository.AddressRepository;
import shop.repository.ProductRepository;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;
import shop.service.impl.UserServiceImpl;
import shop.tools.Tools;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private URoleRepository uRoleRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private URoleService uRoleService;
    @Mock
    private Tools tools;
    @InjectMocks
    private ModelMapper modelMapper;
    @InjectMocks
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void registerNewUser_whenUserIsValid_ShouldReturnUser() {
        UserService userService = new UserServiceImpl(userRepository, addressRepository, productRepository,
                modelMapper, uRoleService, uRoleRepository, bCryptPasswordEncoder, tools);

        UserServiceModel userForSave = new UserServiceModel();
        AddressServiceModel addressServiceModel = new AddressServiceModel();
        List<ProductServiceModel> boughtProducts = new ArrayList<>();
        userForSave.setId("23423-234kjdsf-23");
        userForSave.setUsername("desito");
        userForSave.setPassword("238jdshd");
        userForSave.setConfirmPassword("238jdshd");
        userForSave.setEmail("desito@desito.bg");
        userForSave.setFirstName("Desislava");
        userForSave.setLastName("Ivanova");
        userForSave.setPhoneNumber("+359000000000");
        addressServiceModel.setId("398475jhdf73");
        addressServiceModel.setCountry("Bulgaria");
        addressServiceModel.setCity("Sofia");
        addressServiceModel.setPostCode("1000");
        addressServiceModel.setStreet("Vitoshka");
        addressServiceModel.setStreetNumb("1A");
        userForSave.setAddress(addressServiceModel);
        userForSave.setBoughtProducts(boughtProducts);

        Mockito.when(this.userRepository.saveAndFlush(
                this.modelMapper.map(userForSave, User.class)
        )).thenReturn(this.modelMapper.map(userForSave, User.class));

        UserServiceModel usm = userService.register(userForSave);
        Assert.assertEquals("desito", usm.getUsername());

    }*/





















    /*@Test
    void buyProduct() {
    }

    @Test
    void updateProfile() {
    }

    @Test
    void getAllUserRoles() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void findUserByUsername() {
    }

    @Test
    void findUserById() {
    }

    @Test
    void removeAllProductCart() {
    }

    @Test
    void removeOneProductCart() {
    }*/
