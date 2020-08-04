package shop.service.interfaces;

import shop.error.UpdateManufacturerException;
import shop.models.service.ManufacturerServiceModel;

import java.util.List;

public interface ManufacturerService {

    /**
     * Loads all manufactures when the project is first launched
     * with an empty database
     */
    void initDefaultManufacturer();

    /**
     * Returns all manufacturers in the store
     * @return List<ManufacturerServiceModel>
     */
    List<ManufacturerServiceModel> getAllManufacturers();

    /**
     * Adds a manufacturer to the shop
     * @param msm
     * @return ManufacturerServiceModel
     */
    ManufacturerServiceModel addManufacturer(ManufacturerServiceModel msm);

    /**
     * Loads the manufacturer update page
     * @param msm
     * @return ManufacturerServiceModel
     * @throws UpdateManufacturerException
     */
    ManufacturerServiceModel updateManufacturer(ManufacturerServiceModel msm) throws UpdateManufacturerException;

    /**
     * Deletes all manufacturers in store
     * @param manufacturerId
     */
    void deleteManufacturer(String manufacturerId);

    /**
     * Saves new changes for manufacturer
     * @param msm
     */
    void saveManufacturer(ManufacturerServiceModel msm);

    //ManufacturerServiceModel allManufacturer(ManufacturerServiceModel msm);
}
