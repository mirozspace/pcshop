package shop.web.controllers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.FAQ_VIEW;
import static shop.constants.ControllerPaths.GET_MAPPING_FAQ;

@Controller
public class FaqController {

    @PageTitle(name = "FAQ")
    @GetMapping(GET_MAPPING_FAQ)
    public String name() {
        return FAQ_VIEW;
    }
}