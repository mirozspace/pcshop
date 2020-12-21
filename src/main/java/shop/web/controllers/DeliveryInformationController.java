package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.DELIVERY_INFORMATION_VIEW;
import static shop.constants.ControllerPaths.GET_MAPPING_DELIVERY_INFORMATION;

@Controller
public class DeliveryInformationController {

    @PageTitle(name = "Delivery Information")
    @GetMapping("/delivery-information")
    public String name() {
        return "infopr/delivery-information";
    }
}
