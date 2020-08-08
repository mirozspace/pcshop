package shop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import shop.models.bindings.UserRegisterBindingModel;
import shop.models.service.NewPasswordServiceModel;
import shop.models.views.NewPasswordViewModel;
import shop.service.NewPasswordService;

@Controller
public class PSGenerator {
	
	private final NewPasswordService newPasswordService;
    private final ModelMapper modelMapper;

    @Autowired
    public PSGenerator(NewPasswordService newPasswordService, ModelMapper modelMapper) {
        this.newPasswordService = newPasswordService;
        this.modelMapper = modelMapper;
    }

    //@GetMapping({"/", "home"})
    @GetMapping({"/psg"})
    public String psg(Model model) {
    	if (!model.containsAttribute("newPasswordViewModel")) {
            model.addAttribute("newPasswordViewModel", new NewPasswordViewModel());
        }
        return "psg";
    }

    @PostMapping("/psg")
    public String psgPost(@ModelAttribute NewPasswordViewModel newPasswordViewModel,
    		RedirectAttributes redirectAttributes) {
    	System.out.println();
        NewPasswordServiceModel newPassword
                = this.modelMapper.map(newPasswordViewModel, NewPasswordServiceModel.class);
        String newPass = this.newPasswordService.getRandomPassword(newPassword);
        if (newPass == null){
            newPass = "You have not selected any options.";
        }
        redirectAttributes.addFlashAttribute("newPasswordViewModel", newPasswordViewModel);
        redirectAttributes.addFlashAttribute("newPass", newPass);
        return "redirect:/psg";
    }

}

