package shop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.error.category.CategoryAlreadyExistException;
import shop.error.category.CategoryIsNotExistExceprion;
import shop.error.CustomBaseException;
import shop.models.bindings.CategoryAddBindingModel;
import shop.models.bindings.CategorySaveBindingModel;
import shop.models.service.CategoryServiceModel;
import shop.models.views.CategoryViewModel;
import shop.models.views.ProductViewModel;
import shop.service.CategoryService;
import shop.annotation.PageTitle;
import shop.tools.ListShop;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ListShop listShop;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper, ListShop listShop) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.listShop = listShop;
    }

    @PageTitle(name = "Category")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping("/update")
    public String updateCategory(Model model) {
        List<CategoryViewModel> allCategories = this.categoryService.findAllCategories()
                .stream().map(c -> this.modelMapper.map(c, CategoryViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allCategories", allCategories);
        return "category/category-update";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping("/add")
    public String addCategory(Model model) {
        if (!model.containsAttribute("cabm")) {
            model.addAttribute("cabm", new CategoryAddBindingModel());
        }
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        model.addAttribute("allCategories", allCategories);
        return "category/category-add";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addCategoryPost(@Valid @ModelAttribute("cabm") CategoryAddBindingModel cabm,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cabm", bindingResult);
            redirectAttributes.addFlashAttribute("cabm", cabm);
            return "redirect:/category/add";
        }
        CategoryServiceModel csm = this.modelMapper.map(cabm, CategoryServiceModel.class);
        this.categoryService.addCategory(csm);
        return "redirect:/category/add";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("csbm") CategorySaveBindingModel csbm) {
        this.categoryService.saveCategory(this.modelMapper.map(
                csbm, CategoryServiceModel.class));
        return "redirect:/category/update";
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER')")
    @GetMapping("/all")
    public String allCategory(Model model) {
        model.addAttribute(this.listShop.getAllCategories());
        return "category/category-all";
    }    
    
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    //@PreAuthorize("isAuthenticated()")
    //@PreAuthorize("isAnonymous()")  
    @RequestMapping(path = "/selected/{categoryId}")
	public String selectedCategory(@PathVariable("categoryId") String categoryId, Model model) {
    	
    	List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        model.addAttribute("allCategories", allCategories);
        
        CategoryServiceModel category = this.categoryService.findCategoryById(categoryId);
        List<ProductViewModel> selectedProducts = this.listShop.getSelectedProducts(category.getName());
        model.addAttribute("selectedProducts", selectedProducts);
        return "selected_category";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") String categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return "redirect:/category/update";
    }

	@ExceptionHandler({CategoryAlreadyExistException.class, CategoryAlreadyExistException.class,
    	CategoryIsNotExistExceprion.class})
    public ModelAndView handleCategoryException(CustomBaseException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msgError", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
