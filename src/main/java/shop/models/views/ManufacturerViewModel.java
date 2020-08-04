package shop.models.views;

import java.util.List;

public class ManufacturerViewModel extends BaseViewModel {

    private String name;
    private List<ProductViewModel> products;

    public ManufacturerViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewModel> products) {
        this.products = products;
    }
}
