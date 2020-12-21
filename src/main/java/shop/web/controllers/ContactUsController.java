package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.CONTACT_VIEW;
import static shop.constants.ControllerPaths.GET_MAPPING_CONTACT;

@Controller
public class ContactUsController {

    @PageTitle(name = "Contact")
    @GetMapping("/contact")
    public String name() {
        return "info/contact";
    }
}
