package shop.web.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.models.views.ProductViewModel;
import shop.tools.ListShop;

@Controller
@RequestMapping("/product")
public class ProductControllerRest {
	
	private final ListShop listShop;
	
	@Autowired
	public ProductControllerRest(ListShop listShop) {
		this.listShop = listShop;
	}
	
	/*
	 * @GetMapping("/product") public String randomProduct() { System.out.println();
	 * return "random-one-product"; }
	 */
	
	

}


