package shop.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import shop.error.role.URoleIsNotExistException;
import shop.models.entities.Address;
import shop.models.entities.URole;
import shop.models.entities.User;
import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.URoleServiceModel;
import shop.repository.URoleRepository;
import shop.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class URoleServiceTest {

    @MockBean
    private URoleRepository uRoleRepository;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private URoleService uRoleService;

    @Test
    public void seedRolesToDb_whenDataIsCorrect_ShouldReturnTrue() {
        Mockito.when(this.uRoleRepository.count()).thenReturn(0L);
        Assert.assertTrue(this.uRoleService.seedRolesToDb());
    }

    @Test
    public void seedRolesToDb_whenHasRecordsInTableURole_ShouldReturnFalse() {
        Mockito.when(this.uRoleRepository.count()).thenReturn(1L);
        Assert.assertFalse(this.uRoleService.seedRolesToDb());
    }

    @Test
    public void findByAuthority_whenDataIsCorrect_ShouldReturnOneRole() {
        Mockito.when(this.uRoleRepository.findByAuthority("ADMIN"))
                .thenReturn(java.util.Optional.of(new URole("ADMIN")));
        URoleServiceModel uRoleServiceModel = this.uRoleService.findByAuthority("ADMIN");
        Assert.assertEquals("ADMIN", uRoleServiceModel.getAuthority());

    }

    @Test
    public void findByAuthority_whenAuthorityIsNull_ShouldReturnURoleIsNotExistException() {
        Mockito.when(this.uRoleRepository.findByAuthority(null)).thenReturn(null);
        Assertions.assertThrows(URoleIsNotExistException.class, () -> {
            this.uRoleService.findByAuthority(null);
        });
    }

    @Test
    public void findByAuthority_whenRoleIsNull_ShouldReturnURoleIsNotExistException() {
        Mockito.when(this.uRoleRepository.findByAuthority("ADMIN1"))
                .thenReturn(java.util.Optional.of(new URole(null)));
        Assertions.assertThrows(URoleIsNotExistException.class, () -> {
            this.uRoleService.findByAuthority(null);
        });
    }

    @Test
    public void editUserRoles_whenNewRoleIsNull() {
        Mockito.when(this.userRepository.findById("123324375y"))
                .thenReturn(this.getReturnedUser());
        Mockito.when(this.uRoleRepository.findByAuthority("USER"))
                .thenReturn(Optional.of(new URole() {{
                            setId("123");
                            setId("USER");
                        }}));
        Mockito.when(this.uRoleRepository.findByAuthority("ADMIN"))
                .thenReturn(Optional.of(new URole() {{
                    setId("456");
                    setId("ADMIN");
                }}));
        Mockito.when(this.uRoleRepository.findByAuthority("MANAGER"))
                .thenReturn(Optional.of(new URole() {{
                    setId("123");
                    setId("MANAGER");
                }}));
        Mockito.when(this.uRoleRepository.findByAuthority("WORKER"))
                .thenReturn(Optional.of(new URole() {{
                    setId("123");
                    setId("WORKER");
                }}));
        SaveNewRolesServiceModel saveNewRolesServiceModel
                = new SaveNewRolesServiceModel(){{
                    setRoleAdmin("1");
                    setRoleManager("1");
                    setRoleWorker("1");
                    setId("0000");
        }}

    }

    private Optional<User> getReturnedUser() {
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