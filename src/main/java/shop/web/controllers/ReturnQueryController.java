package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.models.bindings.ReturnQueryBindingModel;
import shop.annotation.PageTitle;

import javax.validation.Valid;

import static shop.constants.ControllerPaths.*;

@Controller
public class ReturnQueryController {

    @PageTitle(name = "Return product form")
    @GetMapping(GET_MAPPING_RETURN_QUERY)
    public String returnQuery(Model model) {
        if (!model.containsAttribute("rpbm")) {
            model.addAttribute("rpbm", new ReturnQueryBindingModel());
        }
        return RETURN_QUERY_VIEW;
    }

    @PostMapping(POST_MAPPING_RETURN_QUERY)
    public String returnQueryPost(@Valid @ModelAttribute ("rpbm") ReturnQueryBindingModel rpbm,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.rpbm", rpbm);
            redirectAttributes.addFlashAttribute("rpbm", rpbm);
            return REDIRECT_TO_CATEGORY_ADD;
        }
        //todo
        return REDIRECT_TO_RETURN_QUERY;
    }
}
