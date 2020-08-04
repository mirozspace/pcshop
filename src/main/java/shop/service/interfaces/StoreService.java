package shop.service.interfaces;

import shop.models.service.StoreServiceModel;

import java.util.List;

public interface StoreService {

    /**
     * Add new store's address to db
     * @param ssm
     * @return StoreServiceModel
     */
    StoreServiceModel addStore(StoreServiceModel ssm);

    /**
     * Removes new store's address to db
     * @param storeId
     */
    void deleteStore(String storeId);

    /**
     * Returns all store's addresses
     * @return
     */
    List<StoreServiceModel> getAllStores();
}
