package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.category.CategoryAlreadyExistException;
import shop.error.category.CategoryCantBeSavedException;
import shop.error.category.CategoryIsNotExistExceprion;
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
    public boolean initDefaultCategory() {
        if (this.categoryRepository.count() == 0) {
            for (DefaultCategoryInformation value : DefaultCategoryInformation.values()) {
                this.categoryRepository.saveAndFlush(new Category(value.getName(), value.getDescription()));
            }
        }
        return true;
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
    public boolean deleteCategory(String categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElse(null);
        if (category == null){
            throw new CategoryIsNotExistExceprion("Category is not exist!");
        }
        this.categoryRepository.deleteById(categoryId);
        return true;
    }

    @Override
    public CategoryServiceModel saveCategory(CategoryServiceModel csm) {
        Category c = this.categoryRepository.findByName(csm.getOldName());
        if (c == null) {
            throw new CategoryCantBeSavedException("Category" + csm.getName() + "cannot be saved!");
        }
        c.setName(csm.getName());
        c.setDescription(csm.getDescription());
        return this.modelMapper.map(this.categoryRepository.saveAndFlush(c), CategoryServiceModel.class);
    }

	@Override
	public CategoryServiceModel findCategoryById(String categoryId) {
	Category category = this.categoryRepository.findById(categoryId).orElse(null);
		if(category == null) {
			throw new CategoryIsNotExistExceprion("Category is not exist!");
		}
		return this.modelMapper.map(category, CategoryServiceModel.class);
	}
}
