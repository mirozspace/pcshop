package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.annotation.PageTitle;

import static shop.constants.ControllerPaths.GET_MAPPING_PRIVACY_POLICY;
import static shop.constants.ControllerPaths.PRIVACY_POLICY_VIEW;

@Controller
public class PrivacyPolicyController {

    @PageTitle(name = "Privacy Policy")
    @GetMapping(GET_MAPPING_PRIVACY_POLICY)
    public String name() {
        return PRIVACY_POLICY_VIEW;
    }
}
