package shop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.annotation.PageTitle;
import shop.error.CustomBaseException;
import shop.error.user.UserIsNotExistException;
import shop.models.bindings.SaveNewRolesBindingModel;
import shop.models.service.AuthorityServiceModel;
import shop.models.service.SaveNewRolesServiceModel;
import shop.models.service.UserServiceModel;
import shop.models.views.UserViewModel;
import shop.service.ProductService;
import shop.service.URoleService;
import shop.service.UserService;
import shop.tools.ListShop;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final UserService userService;
	private final ModelMapper modelMapper;
	private final ListShop listShop;
	private final URoleService uRoleService;
	private final ProductService productService;

	@Autowired
	public AdminController(UserService userService, ModelMapper modelMapper, ListShop listShop,
			URoleService uRoleService, ProductService productService) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.listShop = listShop;
		this.uRoleService = uRoleService;
		this.productService = productService;
	}

	@PageTitle(name = "Admin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/user/all")
	public String getAllUsers(Model model) {
		List<UserViewModel> allUsers = this.listShop.getAllUser();
		allUsers.sort(Comparator.comparing(UserViewModel::getUsername));
		model.addAttribute("allUsers", allUsers);
		return "admin/user-all";
	}

	@PageTitle(name = "Admin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/edit/roles/{userId}")
	public String editUserRoles(@PathVariable("userId") String userId, Model model) {
		UserServiceModel userForEdit = this.userService.findUserById(userId);
		model.addAttribute("userForEdit", userForEdit);
		return "admin/user-edit-roles";
	}

	@PageTitle(name = "Admin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/user/category-save")
	public String saveNewCategoryPost(@ModelAttribute("snrbm") SaveNewRolesBindingModel snrbm) {
		SaveNewRolesServiceModel snrsm = this.modelMapper.map(snrbm, SaveNewRolesServiceModel.class);
		this.uRoleService.editUserRoles(snrsm);
		return "redirect:/admin/user/all";
	}
	
	@PageTitle(name = "Admin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/product/add-default")
	public String addDefaultProducts() {
		this.productService.addDefaultProducts();
		return "redirect:/home";
	}
	
	
	@PageTitle(name = "Admin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/user/delete/{userId}")
	public String deleteUserById(@PathVariable("userId") String userId) {
		this.userService.deleteUserById(userId);
		return "redirect:/admin/user/all";
		
	}

	@Deprecated
	private boolean isHasThisRole(List<UserViewModel> allUsers, String role) {
		for (UserViewModel u : allUsers) {
			for (AuthorityServiceModel r : u.getAuthorities()) {
				if (r.getAuthority().equals(role)) {
					return true;
				}
			}
		}
		return false;
	}

	@ExceptionHandler({ UserIsNotExistException.class })
	public ModelAndView handleAdminException(CustomBaseException e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msgError", e.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
