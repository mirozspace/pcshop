package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.store.StoreAlreadyExistException;
import shop.error.store.StoreIsNotExistException;
import shop.models.entities.Store;
import shop.models.service.StoreServiceModel;
import shop.repository.StoreRepository;
import shop.service.StoreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, ModelMapper modelMapper) {
        this.storeRepository = storeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StoreServiceModel addStore(StoreServiceModel ssm) {
        Store storeFromDb = this.storeRepository.findByName(ssm.getName()).orElse(null);
        if (storeFromDb != null){
            throw new StoreAlreadyExistException(ssm.getName());
        }
        Store storeToDb = this.modelMapper.map(ssm, Store.class);
        Store returnedStore = this.storeRepository.saveAndFlush(storeToDb);
        return this.modelMapper.map(returnedStore, StoreServiceModel.class);
    }

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
}
