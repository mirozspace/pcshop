package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.GET_MAPPING_TERM_AND_CONDITION;
import static shop.constants.ControllerPaths.TERM_AND_CONDITION_VIEW;

@Controller
public class TermsAndConditionsController {

    @PageTitle(name = "Term and Conditions")
    @GetMapping(GET_MAPPING_TERM_AND_CONDITION)
    public String name() {
        return TERM_AND_CONDITION_VIEW;
    }
}
