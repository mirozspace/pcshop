package shop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.models.views.CategoryViewModel;
import shop.models.views.ProductViewModel;
import shop.tools.ListShop;
import java.util.List;
import static shop.constants.ControllerPaths.*;

@Controller
public class HomeController {

	/*
	 * @Value("${serverPath}") private String serverPath;
	 */
    private final ListShop listShop;
    //private final Environment environment;

    @Autowired
    public HomeController(ListShop listShop, Environment environment) {
        this.listShop = listShop;
        //this.environment = environment;
    }

    @GetMapping(GET_MAPPING_INDEX)
    public String index(){
        return REDIRECT_TO_HOME;
    }

    @GetMapping(GET_MAPPING_HOME)
    public String home(Model model){
        List<ProductViewModel> allProducts = this.listShop.getAllProducts();
        List<CategoryViewModel> allCategories = this.listShop.getAllCategories();
        //model.addAttribute("serverPath", this.serverPath);
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("allCategories", allCategories);
        return HOME_VIEW;
    }
    
    @ResponseBody
	@RequestMapping(value = "/home2" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllProductsJ(Model model) {
		List<ProductViewModel> list = this.listShop.getAllProducts();
		return new ResponseEntity<List<ProductViewModel>>(list, HttpStatus.OK);
	}

}

/*
* @Value("${userBucket.path}")
private String userBucketPath;
* */