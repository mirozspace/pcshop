package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.CategoryAlreadyExistException;
import shop.error.CategoryCantBeSaved;
import shop.error.CategoryIsNotExistExceprion;
import shop.models.entities.Category;
import shop.models.service.CategoryServiceModel;
import shop.repository.CategoryRepository;
import shop.service.CategoryService;
import shop.util.DefaultCategoryInformation;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    @Override
    public void initDefaultCategory() {
        if (this.categoryRepository.count() == 0) {
            for (DefaultCategoryInformation value : DefaultCategoryInformation.values()) {
                this.categoryRepository.saveAndFlush(new Category(value.getName(), value.getDescription()));
            }
        }
    }

    @Override
    public CategoryServiceModel addCategory(CategoryServiceModel csm) {
        Category fCategory = this.categoryRepository.findByName(csm.getName());
        if (fCategory != null) {
            throw new CategoryAlreadyExistException(csm.getName());
        }
        Category newCategory = this.modelMapper.map(csm, Category.class);
        return this.modelMapper.map(this.categoryRepository.saveAndFlush(newCategory), CategoryServiceModel.class);
    }

    @Override
    public List<CategoryServiceModel> getAllCategorise() {
        return this.categoryRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryServiceModel> findAllCategories() {
        return this.categoryRepository.findAll()
                .stream().map(c -> this.modelMapper.map(c, CategoryServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(String categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public void saveCategory(CategoryServiceModel csm) {
        Category c = this.categoryRepository.findByName(csm.getOldName());
        if (c == null) {
            throw new CategoryCantBeSaved("Category" + csm.getName() + "cannot be saved!");
        }
        c.setName(csm.getName());
        c.setDescription(csm.getDescription());
        this.categoryRepository.saveAndFlush(c);
    }

	@Override
	public CategoryServiceModel findCategoryById(String categoryId) {
	Category category = this.categoryRepository.findById(categoryId).orElse(null);
		if(category == null) {
			throw new CategoryIsNotExistExceprion("Category is not exist!");
		}
		return this.modelMapper.map(category, CategoryServiceModel.class);
	}
    



   /* @Override
    public CategoryServiceModel updateCategory(CategoryServiceModel csm) {
        CategoryServiceModel returnedCategory = null;
        Category category = this.categoryRepository.findById(csm.getName()).orElse(null);
        if (category != null) {
            category.setName(csm.getName());
            category.setDescription(csm.getDescription());
            this.categoryRepository.saveAndFlush(category);
        } else {
            //niakakva greshka
        }
        return returnedCategory;
    }*/
}
