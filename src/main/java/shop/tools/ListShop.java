package shop.tools;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.models.views.*;
import shop.service.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListShop {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final StoreService storeService;
    private final OrderService orderService;
    private final UserService userService;
    private final ManufacturerService manufacturerService;
    private final ModelMapper modelMapper;
    private final Tools tools;

    @Autowired
    public ListShop(ProductService productService, CategoryService categoryService,
                    StoreService storeService, OrderService orderService,
                    UserService userService, ManufacturerService manufacturerService, ModelMapper modelMapper, Tools tools) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.storeService = storeService;
        this.orderService = orderService;
        this.userService = userService;
        this.manufacturerService = manufacturerService;
        this.modelMapper = modelMapper;
        this.tools = tools;
    }

    public List<ProductViewModel> getAllProducts() {
        return this.productService.getAllProduct()
                .stream()
                .map(c -> this.modelMapper.map(c, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    public List<CategoryViewModel> getAllCategories() {
        return this.categoryService.getAllCategorise()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryViewModel.class))
                .collect(Collectors.toList());
    }

    public List<ManufacturerViewModel> getAllManufacturers() {
        return this.manufacturerService.getAllManufacturers()
                .stream()
                .map(c -> this.modelMapper.map(c, ManufacturerViewModel.class))
                .collect(Collectors.toList());
    }

    public List<StoreViewModel> getAllStores() {
        return this.storeService.getAllStores()
                .stream()
                .map(st -> this.modelMapper.map(st, StoreViewModel.class))
                .collect(Collectors.toList());
    }

    public List<URoleViewModel> getAllUserRoles() {
        return this.userService.getAllUserRoles(this.tools.getLoggedUser())
                .stream()
                .map(ur -> this.modelMapper.map(ur, URoleViewModel.class))
                .collect(Collectors.toList());
    }

    public List<UserViewModel> getAllUser() {
        return this.userService.getAllUsers()
                .stream().map(u -> this.modelMapper.map(u, UserViewModel.class))
                .collect(Collectors.toList());
    }

    public List<OrderViewModel> getAllOrders() {
        return this.orderService.getAllOrders()
                .stream().map(u -> this.modelMapper.map(u, OrderViewModel.class))
                .collect(Collectors.toList());
    }

	public List<ProductViewModel> getSelectedProducts(String name) {
		return this.getAllProducts()
				.stream().filter(pr -> pr.getCategory().getName().equals(name))
				.collect(Collectors.toList());
	}

}
