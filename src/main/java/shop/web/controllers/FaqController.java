package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.FAQ_VIEW;
import static shop.constants.ControllerPaths.GET_MAPPING_FAQ;

@Controller
public class FaqController {

    @PageTitle(name = "FAQ")
    @GetMapping("faq")
    public String name() {
        return "info/faq";
    }
}
