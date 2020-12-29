package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

@Controller
public class DeliveryInformationController {

    @PageTitle(name = "Delivery Information")
    @GetMapping("/delivery-information")
    public String name() {
        return "infopr/delivery-information";
    }
}
