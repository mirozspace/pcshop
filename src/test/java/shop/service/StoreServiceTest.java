package shop.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

@SpringBootTest
public class StoreServiceTest {

	@MockBean
	StoreRepository mockedStoreRepository;
	@InjectMocks
	StoreServiceImpl storeServiceImpl;
	@Autowired
	ModelMapper mapper;

	private StoreServiceModel storeServiceModel;
	private Store returnedStore;
	private Address address;

	@BeforeEach
	public void setup() {
		//this.mockedStoreRepository = Mockito.mock(StoreRepository.class);
		this.address = this.getAddress();
		this.storeServiceImpl = new StoreServiceImpl(this.mockedStoreRepository, this.mapper);
		this.returnedStore = this.getReturnedStore();
		this.storeServiceModel = this.getStoreServiceModel();

	}

	@Test
	public void addStore_whenStoreExist_returnStore() {
		Mockito.when(this.mockedStoreRepository.findByName(Mockito.anyString())).
			thenReturn(Optional.of(returnedStore));
		Assertions.assertThrows(StoreAlreadyExistException.class, () -> {
		    this.storeServiceImpl.addStore(storeServiceModel);
		  });
	}

	@Test
	public void addStore_whenStoreIsNotExist() {

		Mockito.when(this.mockedStoreRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
		Mockito.when(this.mockedStoreRepository.saveAndFlush(Mockito.any())).thenReturn(this.returnedStore);

		Store storeFromDb = this.mockedStoreRepository.findByName(Mockito.anyString()).orElse(null);
		if (storeFromDb != null) {
			throw new StoreAlreadyExistException(this.getStoreServiceModel().getName());
		}
		Store storeToDb = this.mapper.map(this.getStoreServiceModel(), Store.class);
		StoreServiceModel expected = this.mapper.map(storeToDb, StoreServiceModel.class);
		StoreServiceModel actual = this.storeServiceImpl.addStore(this.storeServiceModel);
		Assertions.assertEquals(expected.getName(), actual.getName());
	}

	/*
	@Override
    public boolean deleteStore(String storeId) {
        Store store = this.storeRepository.findById(storeId).orElse(null);
        if (store == null){
            throw new StoreIsNotExistException("Store is not exist");
        }
        this.storeRepository.deleteById(storeId);
        return true;
    }

    @Override
    public List<StoreServiceModel> getAllStores() {
        return this.storeRepository.findAll()
                .stream().map(st -> this.modelMapper.map(st, StoreServiceModel.class))
                .collect(Collectors.toList());
    }
	 */


	public Store getReturnedStore() {
		Store store = new Store();
		store.setId("873425629x");
		store.setName("PcShop");
		store.setOwners("Me");
		store.setAddress(this.address);
		store.setEmail("desito@desito.com");
		store.setPhone("+359000000000");
		return store;
	}

	public StoreServiceModel getStoreServiceModel() {
		StoreServiceModel storeServiceModel = new StoreServiceModel();
		storeServiceModel.setId("873425629x");
		storeServiceModel.setName("PcShop");
		storeServiceModel.setOwners("Me");
		storeServiceModel.setAddress(this.address);
		storeServiceModel.setEmail("desito@desito.com");
		storeServiceModel.setPhone("+359000000000");
		return storeServiceModel;
	}

	private Address getAddress() {
		Address address = new Address();
		address.setId("84834sfjg");
		address.setCountry("Bulgaria");
		address.setCity("Ruse");
		address.setPostCode("7000");
		address.setStreet("Pliska");
		address.setStreetNumb("10");
		return address;
	}
}