package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;
//import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.*;

@Controller
public class AboutController {

    @PageTitle(name = "About")
    @GetMapping(GET_MAPPING_ABOUT)
    public String name(){
        return ABOUT_VIEW;
    }
}
