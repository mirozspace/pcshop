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
import shop.error.*;
import shop.models.bindings.ProductBindingModel;
import shop.models.service.ProductServiceModel;
import shop.models.views.CategoryViewModel;
import shop.models.views.ManufacturerViewModel;
import shop.models.views.ProductViewModel;
import shop.service.ProductService;
import shop.annotation.PageTitle;
import shop.tools.ListShop;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static shop.constants.ControllerPaths.*;

@Controller
@RequestMapping(REQUEST_MAPPING_PRODUCT)
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final ListShop listShop;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper, ListShop listShop) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.listShop = listShop;
    }

    @PageTitle(name = "Product")
    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @GetMapping(GET_MAPPING_PRODUCT_ADD)
    public String productAdd(Model model) {
    	
        if (!model.containsAttribute("pabm")) {
            model.addAttribute("pabm", new ProductBindingModel());
        }
        
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        List<ManufacturerViewModel> allManufacturers = this.listShop.getAllManufacturers();
        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allManufacturers", allManufacturers);
        return PRODUCT_ADD_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @PostMapping(POST_MAPPING_PRODUCT_ADD)
    public String productAddConfirm(@Valid @ModelAttribute("pabm") ProductBindingModel pabm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Model model) throws IOException {
    	System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pabm", bindingResult);
            redirectAttributes.addFlashAttribute("pabm", pabm);
            return REDIRECT_TO_PRODUCT_ADD;
        }
        this.productService.addProduct(this.modelMapper.map(pabm, ProductServiceModel.class));
        return REDIRECT_TO_HOME;
    }


    @PageTitle(name = "Product Update")
    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @GetMapping("/update/{productId}")
    public String productUpdate(@PathVariable("productId") String productId, Model model) {
        if (!model.containsAttribute("pbmupdate")) {
            model.addAttribute("pbmupdate", new ProductBindingModel());
        }
        ProductServiceModel psm = this.productService.findByProductId(productId);
        ProductViewModel pvmupdate = this.modelMapper.map(psm, ProductViewModel.class);
        model.addAttribute("pvmupdate", pvmupdate);
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        List<ManufacturerViewModel> allManufacturers = this.listShop.getAllManufacturers();
        model.addAttribute("allCategoriesU", allCategories);
        model.addAttribute("allManufacturersU", allManufacturers);
        return "product/product-update";
    }

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @PostMapping("/update")
    public String productUpdate(@ModelAttribute("pbmupdate") ProductBindingModel pbmupdate,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) throws IOException {
        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pbmupdate", pbmupdate);
            redirectAttributes.addFlashAttribute("pbmupdate", pbmupdate);
            return "redirect:/product/product-update";
        }

        ProductServiceModel psm = this.modelMapper.map(pbmupdate, ProductServiceModel.class);
        this.productService.updateProduct(psm);
        return "redirect:/product/product-update";
    }

    @ExceptionHandler({ProductIsNotExistException.class})
    public ModelAndView handleUserException(CustomBaseException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msgError", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }


    /*@PageTitle(name = "Product Edit")
    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @GetMapping("/update/{productId}")
    public String productUpdateById(@PathVariable("productId") String productId, Model model) {
        return "product/product-update";
    }*/







    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @RequestMapping(path = REQUEST_MAPPING_PRODUCT_DELETE)
    public String deleteProductFromCartById(@PathVariable("productId") String productId) {
        this.productService.deleteProductFromCartById(productId);
        return REDIRECT_TO_HOME;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(GET_MAPPING_DELETE_ALL_PRODUCTS)
    public String deleteAllProducts(){
    	this.productService.deleteAllProducts();
    	return REDIRECT_TO_HOME;
    }
}






















 /*
        @GetMapping("/product-delete")
    public String deleteProductBtId(@RequestParam(name = "productId") String productId) {
        this.productService.deleteProduct(productId);
        return "acp/product-all";
    }

        @GetMapping("/pathvars/item/{itemId}/detail/{dtlId}")
        public String multiplePathVariable(@PathVariable("itemId") int itemId,
        @PathVariable("dtlId") int dtlId, Model model) {
    */