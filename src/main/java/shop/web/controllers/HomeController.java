package shop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.models.views.CategoryViewModel;
import shop.models.views.ProductViewModel;
import shop.tools.ListShop;
import java.util.List;
import static shop.constants.ControllerPaths.*;

@Controller
public class HomeController {

    private final ListShop listShop;

    @Autowired
    public HomeController(ListShop listShop, Environment environment) {
        this.listShop = listShop;
    }

    @GetMapping(GET_MAPPING_INDEX)
    public String index(){
        return REDIRECT_TO_HOME;
    }

    @GetMapping(GET_MAPPING_HOME)
    public String home(Model model){
        List<ProductViewModel> allProducts = this.listShop.getAllProducts();
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("allCategories", allCategories);
        return HOME_VIEW;
    }

}
