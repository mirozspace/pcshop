package shop.service.interfaces;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.models.entities.Address;
import shop.models.entities.URole;
import shop.models.entities.User;
import shop.models.service.UserServiceModel;
import shop.repository.AddressRepository;
import shop.repository.ProductRepository;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;
import shop.service.impl.UserServiceImpl;
import shop.tools.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @MockBean
    private UserRepository mockedUserRepository;
    @MockBean
    private AddressRepository mockedAddressRepository;
    @MockBean
    private ProductRepository mockedProductRepository;
    private ModelMapper modelMapper;
    @MockBean
    private URoleService uRoleService;
    @MockBean
    private URoleRepository uRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @MockBean
    private Tools tools;

    @MockBean
    private Address address;
    private User testUser;

    @Before
    public void init() {
        this.testUser = this.getUser();
        this.modelMapper = new ModelMapper();
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void userService_GetUserWithCorrectUsername_ShouldReturnCorrect() {
        when(this.mockedUserRepository.findByUsername("desito1"))
                .thenReturn(java.util.Optional.ofNullable(this.testUser));
        UserService userService = new UserServiceImpl(this.mockedUserRepository,
                this.mockedAddressRepository, this.mockedProductRepository, this.modelMapper,
                this.uRoleService, this.uRoleRepository, this.bCryptPasswordEncoder, this.tools);

        User expected = this.testUser;
        UserServiceModel actual = userService.findUserByUsername("desito1");
        Assert.assertEquals("Broken...", expected.getId(), actual.getId());
        Assert.assertEquals("Broken...", expected.getUsername(), actual.getUsername());
        Assert.assertEquals("Broken...", expected.getPassword(), actual.getPassword());
    }

    private User getUser() {
        User u = new User();
        u.setId("bed5557d-04d0-452c-8395-89e4e6248e95");
        u.setUsername("desito1");
        u.setPassword("23&4sdHf");
        u.setFirstName("Desisava");
        u.setLastName("Ivanova");
        u.setPhoneNumber("+359000000000");
        u.setAddress(new Address());
        u.setBoughtProducts(new ArrayList<>());
        u.setEmail("desito@desi.bg");
        u.setAuthorities(new HashSet<URole>(Arrays.asList(
                new URole("ADMIN")
        )));
        return u;
    }
}