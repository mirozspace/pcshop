package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.StoreExistException;
import shop.models.entities.Store;
import shop.models.service.StoreServiceModel;
import shop.repository.StoreRepository;
import shop.service.interfaces.StoreService;

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
            throw new StoreExistException(ssm.getName());
        }
        Store storeToDb = this.modelMapper.map(ssm, Store.class);
        return this.modelMapper.map(storeToDb, StoreServiceModel.class);
    }

    @Override
    public void deleteStore(String storeId) {
        this.storeRepository.deleteById(storeId);
    }

    @Override
    public List<StoreServiceModel> getAllStores() {
        return this.storeRepository.findAll()
                .stream().map(st -> this.modelMapper.map(st, StoreServiceModel.class))
                .collect(Collectors.toList());
    }
}
