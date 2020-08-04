package shop.models.service;

import java.util.List;

public class ManufacturerServiceModel extends BaseServiceModel{

	private String name;
	private String oldName;
    private List<ProductServiceModel> products;

    public ManufacturerServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductServiceModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductServiceModel> products) {
        this.products = products;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
}
