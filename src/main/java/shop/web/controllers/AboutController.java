package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.ABOUT_VIEW;

//import shop.annotation.PageTitle;

@Controller
public class AboutController {

    @PageTitle(name = "About")
    @GetMapping("/about")
    public String name(){
        return ABOUT_VIEW;
    }
}
