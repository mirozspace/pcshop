package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

@Controller
public class FaqController {

    @PageTitle(name = "FAQ")
    @GetMapping("faq")
    public String name() {
        return "info/faq";
    }
}
