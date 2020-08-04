package shop.service.interfaces;

import shop.models.service.CategoryServiceModel;

import java.util.List;

public interface CategoryService {

    /**
     * Loads all categories when the project is first launched
     * with an empty database
     */
    void initDefaultCategory();

    /**
     * Adds new category to the store
     * @param csm will be accepted
     * @return CategoryServiceModel
     */
    CategoryServiceModel addCategory(CategoryServiceModel csm);

    /**
     * Deletes the category by id (categoryId)
     * @param categoryId
     */
    void deleteCategory(String categoryId);

    /**
     * Save new category to store
     * @param msm
     */
    void saveCategory(CategoryServiceModel msm);

    /**
     * Deletes all categories in shop
     * @return CategoryServiceModel
     */
    List<CategoryServiceModel> getAllCategorise();

    /**
     * Deletes all categories in shop
     * @return CategoryServiceModel
     */
    //???
    List<CategoryServiceModel> findAllCategories();

    /**
     * Find a category by id (categoryId)
     * @param categoryId
     * @return CategoryServiceModel
     */
    CategoryServiceModel findCategoryById(String categoryId);

    //CategoryServiceModel updateCategory(CategoryServiceModel csm);
}
