package shop.service;

import shop.error.manufacturer.ManufacturerUpdateException;
import shop.models.service.ManufacturerServiceModel;

import java.util.List;

public interface ManufacturerService {

    long initDefaultManufacturer();

    List<ManufacturerServiceModel> getAllManufacturers();

    ManufacturerServiceModel addManufacturer(ManufacturerServiceModel msm);

    ManufacturerServiceModel updateManufacturer(ManufacturerServiceModel msm) throws ManufacturerUpdateException;

    boolean deleteManufacturer(String manufacturerId);

    ManufacturerServiceModel saveManufacturer(ManufacturerServiceModel msm);
}
