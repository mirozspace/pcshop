package shop.service;

import shop.models.service.ProductServiceModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<ProductServiceModel> getAllProduct();

    List<ProductServiceModel> getAllProductByCategory(String category);

    ProductServiceModel addProduct(ProductServiceModel psm) throws IOException;

    boolean deleteProductFromDbById(String id);

    boolean deleteAllProducts();

    ProductServiceModel findByProductId(String productId);

    boolean addDefaultProducts();

    ProductServiceModel updateProduct(ProductServiceModel psm) throws IOException;

}
