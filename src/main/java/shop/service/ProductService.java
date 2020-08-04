package shop.service;

import shop.models.service.ProductServiceModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    /**
     * Get all products
     * @return List<ProductServiceModel>
     */
    List<ProductServiceModel> getAllProduct();

    /**
     * Get all products in current directory
     * @param category
     * @return List<ProductServiceModel>
     */
    List<ProductServiceModel> getAllProductByCategory(String category);

    /**
     * Add new product to store
     * @param psm
     * @return ProductServiceModel
     * @throws IOException
     */
    ProductServiceModel addProduct(ProductServiceModel psm) throws IOException;

    /**
     * Delete one product from user's products list
     * @param id
     */
    void deleteProductFromCartById(String id);

    /**
     * Delete all products in shop
     */
    void deleteAllProducts();

    /**
     * Finds product by id (productId)
     * @param productId
     * @return
     */
    ProductServiceModel findByProductId(String productId);

    /**
     * Adds list with default products, only for test
     */
	void addDefaultProducts();

    /**
     * Load page for update of product
     * @param psm
     * @return ProductServiceModel
     * @throws IOException
     */
    ProductServiceModel updateProduct(ProductServiceModel psm) throws IOException;

    /**
     * ...
     * @return
     */
    List<ProductServiceModel> getAllProductRest();
}
