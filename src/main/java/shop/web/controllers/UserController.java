package shop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.error.*;
import shop.error.address.AddressIsNotExistException;
import shop.error.user.*;
import shop.models.bindings.UserProfileUpdateBindingModel;
import shop.models.bindings.UserRegisterBindingModel;
import shop.models.service.UserServiceModel;
import shop.models.views.*;
import shop.service.OrderService;
import shop.service.UserService;
import shop.annotation.PageTitle;
import shop.tools.ListShop;
import shop.tools.Tools;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static shop.constants.ControllerPaths.*;

@Controller
@RequestMapping(REQUEST_MAPPING_USER)
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ListShop listShop;
    private final Tools tools;
    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, ListShop listShop,
                          Tools tools, OrderService orderService) {
        this.tools = tools;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.listShop = listShop;
        this.orderService = orderService;
    }

    @PageTitle(name = "User Login")
    @GetMapping(GET_MAPPING_USER_LOGIN)
    public String login(Model model) {
        List<ProductViewModel> allProducts = this.listShop.getAllProducts();
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("allCategories", allCategories);
        return LOGIN_VIEW;
    }

    @PageTitle(name = "User register")
    @GetMapping(GET_MAPPING_USER_REGISTER)
    public String register(Model model) {
        if (!model.containsAttribute("urbm")) {
            model.addAttribute("urbm", new UserRegisterBindingModel());
        }
        //List<ProductViewModel> allProducts = this.listShop.getAllProducts();
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        model.addAttribute("allCategories", allCategories);
        return REGISTER_VIEW;
    }

    @PostMapping(POST_MAPPING_USER_REGISTER)
    public String registerConfirm(@Valid @ModelAttribute("urbm") UserRegisterBindingModel urbm,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            //urbm.setPassword("");
            //urbm.setConfirmPassword("");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.urbm", bindingResult);
            redirectAttributes.addFlashAttribute("urbm", urbm);
            return REDIRECT_TO_REGISTER;
        }
        if (!urbm.getPassword().equals(urbm.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("passwordsNotMatch", true);
            redirectAttributes.addFlashAttribute("urbm", urbm);
        }

        this.userService.register(this.modelMapper.map(urbm, UserServiceModel.class));
        return REDIRECT_TO_LOGIN;
    }

    @PageTitle(name = "User Profile")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(GET_MAPPING_USER_PROFILE)
    public String userProfile(Model model) {
        String userStr = this.tools.getLoggedUser();
        UserProfileViewModel userToView = this.modelMapper.map(
                this.userService.findUserByUsername(userStr), UserProfileViewModel.class);
        model.addAttribute("userToView", userToView);
        return PROFILE_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(path = GET_MAPPING_PRODUCT_ADD_TO_CART)
    public String addToCart(@PathVariable("productId") String productId) throws UserCannotSaveException {
        if (!"anonymousUser".equals(this.tools.getLoggedUser())) {
            this.userService.buyProduct(productId, this.tools.getLoggedUser());
            return REDIRECT_TO_USER_CART;
        } else {
            //niakakva greshka...
            return REDIRECT_TO_HOME;
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(path = "/remove-all-from-cart")
    public String removeAllFromCart() {
        if (!"anonymousUser".equals(this.tools.getLoggedUser())) {
            this.userService.removeAllProductCart(this.tools.getLoggedUser());
            return CART_VIEW;
        } else {
            //niakakva greshka...
            return HOME_VIEW;
        }
    }

    //http://localhost:8000/product/remove-from-cart/0b5e6d87-cc02-4fc7-aaa2-79e7630966f8
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(GET_MAPPING_PRODUCT_REMOVE_FROM_CART)
    public String removeFromCart(@PathVariable("productId") String productId) {
        if (!"anonymousUser".equals(this.tools.getLoggedUser())) {
            this.userService.removeOneProductCart(productId, this.tools.getLoggedUser());
        }
        return CART_VIEW;
    }

    @PageTitle(name = "Profile Update")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(GET_MAPPING_USER_PROFILE_UPDATE)
    public String userUpdateProfile(Model model) {
        UserServiceModel usm = this.userService.findUserByUsername(this.tools.getLoggedUser());
        UserProfileUpdateViewModel uvm = this.modelMapper.map(usm, UserProfileUpdateViewModel.class);
        model.addAttribute("uvm", uvm);
        return PROFILE_UPDATE_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @PostMapping(POST_MAPPING_USER_PROFILE_UPDATE)
    public String userUpdateProfileConfirm(@ModelAttribute("upu") UserProfileUpdateBindingModel upu,
                                           Model model) {
        this.userService.updateProfile(this.modelMapper.map(upu, UserServiceModel.class));
        return REDIRECT_TO_USER_PROFILE_UPDATE;
    }

    @PageTitle(name = "User Cart")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(GET_MAPPING_USER_CART)
    public String userCart(Model model) {
        if (!"anonymousUser".equals(this.tools.getLoggedUser())) {
            List<ProductViewModel> buyedProducts
                    = this.userService.findUserByUsername(this.tools.getLoggedUser()).getBuyedProducts()
                    .stream().map(pr -> this.modelMapper.map(pr, ProductViewModel.class))
                    .collect(Collectors.toList());
            double totalPrice = getTotalPrice(buyedProducts);
            model.addAttribute("boughtProducts", buyedProducts);
            model.addAttribute("totalPrice", totalPrice);
        } else {
            model.addAttribute("messageNotLogged", "You are not logged!");
        }
        return CART_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER', 'USER')")
    @GetMapping(GET_MAPPING_USER_CART_FINISH)
    public String finishCart() {
        this.orderService.saveOrders();
        return REDIRECT_TO_HOME;
    }
    
    

    @ExceptionHandler({AddressIsNotExistException.class, UserWithUsernameAlreadyExistException.class,
            UsernameNotFoundException.class, UserRegistrationException.class,
            UserWithUsernameAlreadyExistException.class, AddressIsNotExistException.class,
            UserCannotSaveException.class, UserWithThisIdNotFoundException.class,
            UserPasswordsNotMatchException.class})
    public ModelAndView handleUserException(CustomBaseException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msgError", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    private double getTotalPrice(List<ProductViewModel> buyedProducts) {
        double totalPrice = 0.00;
        for (ProductViewModel buyedProduct : buyedProducts) {
            if (buyedProduct.getPrice() != null) {
                totalPrice += buyedProduct.getPrice().doubleValue();
            }
        }
        return totalPrice;
    }
    
    
/*@GetMapping(GET_MAPPING_USER_LOGOUT)
    public String logout() {
        //something
        return HOME_VIEW;
    }*/

    /*
     * private String getLoggedUser() { String username = null; Object principal =
     * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
     * (principal instanceof UserDetails) { username = ((UserDetails)
     * principal).getUsername(); } else { username = principal.toString(); } return
     * username; }
     */
}



