package shop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.ManufacturerIsNotExistException;
import shop.error.UpdateManufacturerException;
import shop.models.entities.Manufacturer;
import shop.models.service.ManufacturerServiceModel;
import shop.repository.ManufacturerRepository;
import shop.util.DefaultManufacturerInformation;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ModelMapper modelMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    @Override
    public void initDefaultManufacturer() {
        if (this.manufacturerRepository.count() == 0) {
            for (DefaultManufacturerInformation value : DefaultManufacturerInformation.values()) {
                this.manufacturerRepository.saveAndFlush(new Manufacturer(value.getName()));
            }
        }
    }

    @Override
    public List<ManufacturerServiceModel> getAllManufacturers() {
        return this.manufacturerRepository.findAll()
                .stream()
                .map(product -> this.modelMapper.map(product, ManufacturerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturerServiceModel addManufacturer(ManufacturerServiceModel msm) {
        Manufacturer fManufacturer = this.manufacturerRepository.findByName(msm.getName());
        if (fManufacturer != null) {
            throw new ManufacturerIsNotExistException("Manufacturer with name " + msm.getName() + " is not exist!");
        }
        Manufacturer m = this.manufacturerRepository.saveAndFlush(this.modelMapper.map(msm, Manufacturer.class));
        return this.modelMapper.map(m, ManufacturerServiceModel.class);
    }

    @Override
    public ManufacturerServiceModel updateManufacturer(ManufacturerServiceModel msm) throws UpdateManufacturerException {
        ManufacturerServiceModel returnedManufacturer = null;
        Manufacturer manufacturer = this.manufacturerRepository.findByName(msm.getName());
        if (manufacturer != null) {
            manufacturer.setName(msm.getName());
            this.manufacturerRepository.saveAndFlush(manufacturer);
        } else {
            throw new UpdateManufacturerException("Manufacturer " + msm.getName() + " cannot be save!");
        }
        return returnedManufacturer;
    }

    @Override
    public void deleteManufacturer(String manufacturerId) {
        this.manufacturerRepository.deleteById(manufacturerId);
    }

    @Override
    public void saveManufacturer(ManufacturerServiceModel msm) {
        Manufacturer m = this.manufacturerRepository.findByName(msm.getOldName());
        if (m == null) {
            throw new ManufacturerIsNotExistException("Manufacturer " + msm.getName() + " is not exist!");
        }
        m.setName(msm.getName());
        this.manufacturerRepository.saveAndFlush(m);
    }


}
