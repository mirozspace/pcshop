package shop.service;

import static org.hamcrest.CoreMatchers.any;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import shop.error.role.URoleIsNotExistException;
import shop.error.store.StoreAlreadyExistException;
import shop.models.entities.Address;
import shop.models.entities.Store;
import shop.models.entities.URole;
import shop.models.service.StoreServiceModel;
import shop.repository.StoreRepository;
import shop.repository.UserRepository;
import shop.service.impl.StoreServiceImpl;

import org.junit.jupiter.api.Assertions;

@RunWith(SpringRunner.class)
class StoreServiceTest {

	@MockBean
	private StoreRepository storeRepository;
	@InjectMocks
	private ModelMapper modelMapper;
	private Store returnedStore;
	private StoreService storeService;
	@Autowired
	private StoreServiceModel storeServiceModel;

	@Before
	public void setup() {
		this.returnedStore = new Store() {{
				setId("873425629x");
				setName("PcShop");
				setOwners("Me");
				setAddress(new Address());
				setEmail("desito@desito.com");
				setPhone("+359000000000");
			}};
		this.storeServiceModel = new StoreServiceModel() {{
				setId("873425629x");
				setName("PcShop");
				setOwners("Me");
				setAddress(new Address());
				setEmail("desito@desito.com");
				setPhone("+359000000000");
			}};
	}

	@Test
	public void addToStore_whenDataIsNull_returnStore() {
		
		Mockito.when(this.storeRepository.findByName("PcComputers1"))
		.thenReturn(Optional.of(this.returnedStore));
		Assertions.assertThrows(StoreAlreadyExistException.class, () -> {
            this.storeService.addStore(storeServiceModel);
        });
	}
}

/* @Override
    public StoreServiceModel addStore(StoreServiceModel ssm) {
        Store storeFromDb = this.storeRepository.findByName(ssm.getName()).orElse(null);
        if (storeFromDb != null){
            throw new StoreAlreadyExistException(ssm.getName());
        }
        Store storeToDb = this.modelMapper.map(ssm, Store.class);
        return this.modelMapper.map(storeToDb, StoreServiceModel.class);
    }
 * 
 * 
 * 
 * @Override public StoreServiceModel addStore(StoreServiceModel ssm) { Store
 * storeFromDb = this.storeRepository.findByName(ssm.getName()).orElse(null); if
 * (storeFromDb != null){ throw new StoreAlreadyExistException(ssm.getName()); }
 * Store storeToDb = this.modelMapper.map(ssm, Store.class); return
 * this.modelMapper.map(storeToDb, StoreServiceModel.class); }
 * 
 * 
 * private Optional<Category> testUser; private CategoryRepository
 * mockedCategoryRepository; private ModelMapper mockedModelMapper; private
 * CategoryName categoryName; private Category categoryRepository;
 * 
 * 
 * public CategoryServiceTest() {
 * 
 * }
 * 
 * @Before() public void init() { this.testUser = Optional.of(new Category() {{
 * setId("aaaa"); setCategoryName(categoryName); setDescription("Dress"); }});
 * 
 * this.mockedCategoryRepository = Mockito.mock(CategoryRepository.class);
 * this.mockedModelMapper = Mockito.mock(ModelMapper.class);
 * 
 * }
 * 
 * 
 * 
 * 
 * package diplomna.web;
 * 
 * import diplomna.model.entity.User; import
 * diplomna.model.service.UserServiceModel; import
 * diplomna.repository.RoleRepository; import
 * diplomna.repository.UserRepository; import diplomna.service.UserService;
 * import diplomna.service.serviceImpl.UserServiceImp; import org.junit.Assert;
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.Mockito;
 * import org.mockito.junit.jupiter.MockitoExtension; import
 * org.modelmapper.ModelMapper; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import java.util.Optional;
 * 
 * @SpringBootTest
 * 
 * @ExtendWith(MockitoExtension.class) public class UserServiceTest {
 * 
 * private Optional<User> testUser; private UserRepository mockedUserRepository;
 * private ModelMapper mockedModelMapper; private RoleRepository roleRepository;
 * 
 * public UserServiceTest() {
 * 
 * }
 * 
 * @Before() public void init() { this.testUser = Optional.of(new User() {{
 * setId("aaaa"); setUsername("Pesho"); setPassword("123"); }});
 * 
 * this.mockedUserRepository = Mockito.mock(UserRepository.class);
 * this.mockedModelMapper = Mockito.mock(ModelMapper.class);
 * 
 * }
 * 
 * @Test public void
 * userService_GetUserWithCorrectUsername_shouldReturnCorrect() {
 * 
 * 
 * Mockito.when(this.mockedUserRepository.findUserByUsername("Pesho"))
 * .thenReturn(this.testUser);
 * 
 * Optional<User> mockedUsers =
 * this.mockedUserRepository.findUserByUsername("Pesho"); Optional<User>
 * mockedUsers2 = this.mockedUserRepository.findUserByUsername("Pesho");
 * UserServiceModel usm = new UserServiceModel(); usm.setUsername("Pesho");
 * Mockito.when(this.mockedModelMapper.map(mockedUsers.get(),
 * UserServiceModel.class)) .thenReturn(usm);
 * 
 * UserService userService = new UserServiceImp(this.mockedUserRepository,
 * roleRepository, null, null, this.mockedModelMapper, null, null);
 * //Optional<User> user = this.mockedUserRepository.findByUsername("Pesho"); //
 * UserServiceModel user2 = userService.findUserByUsername("Pesho");
 * Optional<User> expected = this.testUser; UserServiceModel actual =
 * userService.findByUsername("Pesho");
 * 
 * User findedUser =
 * this.mockedUserRepository.findUserByUsername("Pesho").orElse(null);
 * Optional<User> mockedUsers3 =
 * this.mockedUserRepository.findUserByUsername("Pesho");
 * 
 * 
 * // Assert.assertEquals("4456d57a-fe5b-4b6a-a675-db29933236ac",
 * expected.getId(), model.getId()); Assert.assertEquals("Pesho",
 * expected.get().getUsername(), actual.getUsername()); //
 * Assert.assertEquals("123", expected.getPassword(), model.getPassword()); //
 * System.out.println(user2); } }
 * 
 * 
 * 
 */