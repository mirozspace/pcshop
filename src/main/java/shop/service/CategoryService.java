package shop.service;

import shop.models.service.CategoryServiceModel;

import java.util.List;

public interface CategoryService {

    boolean initDefaultCategory();

    CategoryServiceModel addCategory(CategoryServiceModel csm);

    boolean deleteCategory(String categoryId);

    CategoryServiceModel saveCategory(CategoryServiceModel msm);

    List<CategoryServiceModel> getAllCategorise();

    List<CategoryServiceModel> findAllCategories();

    CategoryServiceModel findCategoryById(String categoryId);

}
