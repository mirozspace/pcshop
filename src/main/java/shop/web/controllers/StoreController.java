package shop.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shop.models.views.StoreViewModel;
import shop.tools.ListShop;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StoreController {

    private final ListShop listShop;

    public StoreController(ListShop listShop) {
        this.listShop = listShop;
    }

    @GetMapping(value = "/store", produces = "application/json")
    @ResponseBody
    public Integer fetchData() {
        List<String> aaa = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();
        a.size();
        return 123;
    }

}
