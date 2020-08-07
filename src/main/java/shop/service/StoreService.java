package shop.service;

import shop.models.service.StoreServiceModel;

import java.util.List;

public interface StoreService {

    StoreServiceModel addStore(StoreServiceModel ssm);

    boolean deleteStore(String storeId);

    List<StoreServiceModel> getAllStores();
}
