package shop.service;

import static org.mockito.Mockito.mock;

import java.util.Optional;
import org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import shop.error.store.StoreAlreadyExistException;
import shop.models.entities.Address;
import shop.models.entities.Store;
import shop.models.service.StoreServiceModel;
import shop.repository.StoreRepository;
import shop.service.impl.StoreServiceImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
class StoreServiceTest {

	private StoreRepository mockedStoreRepository;
	private ModelMapper modelMapper;
	private Store returnedStore;	
	private StoreServiceImpl storeServiceImpl;
	private StoreServiceModel storeServiceModel;

	@BeforeEach
	public void setup() {
		this.returnedStore = this.getReturnedStore();
		this.storeServiceModel = this.getStoreServiceModel();
		this.mockedStoreRepository = mock(StoreRepository.class);
		this.modelMapper = new ModelMapper();
		this.storeServiceImpl = new StoreServiceImpl(mockedStoreRepository, modelMapper);
	}

	@Test
	public void addStore_whenStoreExist_returnStore() {
		Mockito.when(this.mockedStoreRepository.findByName("aaa"))
				.thenReturn(Optional.of(returnedStore));
		Assertions.assertThrows(StoreAlreadyExistException.class, () -> {
			this.storeServiceImpl.addStore(storeServiceModel);
		});
	}

	@Test
	public void addStore_whenStoreIsNotExist() {
		Mockito.when(this.mockedStoreRepository.findByName("aaa")).thenReturn(null);
		Mockito.when(this.mockedStoreRepository.saveAndFlush(any()))
			.thenReturn(this.returnedStore);
		StoreServiceModel actual = this.storeServiceImpl.addStore(storeServiceModel);
		Store expected = this.returnedStore;
		Assertions.assertEquals(expected.getName(), actual.getName());

	}

	@AfterEach
	public void destroy() {
		this.returnedStore = null;
		this.storeServiceModel = null;
		this.mockedStoreRepository = null;
		this.modelMapper = null;
		this.storeServiceImpl = null;
	}

	private Store getReturnedStore() {
		return new Store() {
			{
				setId("873425629x");
				setName("PcShop");
				setOwners("Me");
				setAddress(new Address());
				setEmail("desito@desito.com");
				setPhone("+359000000000");
			}
		};
	}
	
	private StoreServiceModel getStoreServiceModel() {
		return new StoreServiceModel() {{
			setId("873425629x");
			setName("PcShop");
			setOwners("Me");
			setAddress(new Address());
			setEmail("desito@desito.com");
			setPhone("+359000000000");
		}};
	}

	/*
	 * @Override public StoreServiceModel addStore(StoreServiceModel ssm) { Store
	 * storeFromDb = this.storeRepository.findByName(ssm.getName()).orElse(null); if
	 * (storeFromDb != null){ throw new StoreAlreadyExistException(ssm.getName()); }
	 * Store storeToDb = this.modelMapper.map(ssm, Store.class); return
	 * this.modelMapper.map(this.storeRepository.saveAndFlush(storeToDb),
	 * StoreServiceModel.class); }
	 */

}