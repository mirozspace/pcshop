package shop.models.views;

import java.util.List;

public class CategoryViewModel extends BaseViewModel{

    private String name;
    private String description;
    private List<ProductViewModel> products;

    public CategoryViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewModel> products) {
        this.products = products;
    }
}
