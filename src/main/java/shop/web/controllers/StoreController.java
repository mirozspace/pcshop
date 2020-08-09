package shop.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @Deprecated
    @GetMapping(value = "/store", produces = "application/json")
    @ResponseBody
    public Integer fetchData() {
        return null;
    }

}
