package shop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.error.CustomBaseException;
import shop.error.ManufacturerIsNotExistException;
import shop.error.UpdateManufacturerException;
import shop.models.bindings.ManufacturerAddBindingModel;
import shop.models.bindings.ManufacturerUpdateBindingModel;
import shop.models.bindings.ManufacturerSaveBindingModel;
import shop.models.service.ManufacturerServiceModel;
import shop.models.views.ManufacturerViewModel;
import shop.service.interfaces.ManufacturerService;
import shop.annotation.PageTitle;
import shop.tools.ListShop;

import javax.validation.Valid;
import java.util.List;

import static shop.constants.ControllerPaths.*;

@Controller
@RequestMapping(REQUEST_MAPPING_MANUFACTURER)
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    private final ModelMapper modelMapper;
    private final ListShop listShop;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService, ModelMapper modelMapper, ListShop listShop) {
        this.manufacturerService = manufacturerService;
        this.modelMapper = modelMapper;
        this.listShop = listShop;
    }

    @PageTitle(name = "Manufacturer")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping(GET_MAPPING_MANUFACTURER_ADD)
    public String addManufacturer(Model model) {
        if (!model.containsAttribute("mabm")) {
            model.addAttribute("mabm", new ManufacturerAddBindingModel());
        }
        return MANUFACTURER_ADD_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping(POST_MAPPING_MANUFACTURER_ADD)
    public String addManufacturerPost(@Valid @ModelAttribute("mabm") ManufacturerAddBindingModel mabm,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mabm", mabm);
            redirectAttributes.addFlashAttribute("mabm", mabm);
            return REDIRECT_TO_MANUFACTURER_ADD;
        }
        this.manufacturerService.addManufacturer(this.modelMapper.map(mabm, ManufacturerServiceModel.class));
        return REDIRECT_TO_MANUFACTURER_ADD;
    }

    @PageTitle(name = "Manufacturer")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping(GET_MAPPING_MANUFACTURER_UPDATE)
    public String updateManufacturers(Model model) {
        if (!model.containsAttribute("mubm")) {
            model.addAttribute("mubm", new ManufacturerUpdateBindingModel());
        }
        List<ManufacturerViewModel> allManufacturers = this.listShop.getAllManufacturers();
        model.addAttribute("allManufacturers", allManufacturers);
        return MANUFACTURER_UPDATE_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping(POST_MAPPING_MANUFACTURER_UPDATE)
    public String updateManufacturerPost(@Valid @ModelAttribute("mubm") ManufacturerUpdateBindingModel mubm,
                                         BindingResult bindingResult,
                                         RedirectAttributes redirectAttributes,
                                         Model model) throws UpdateManufacturerException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mubm", mubm);
            redirectAttributes.addFlashAttribute("mubm", mubm);
            return REDIRECT_TO_MANUFACTURER_UPDATE;
        }
        this.manufacturerService.updateManufacturer(this.modelMapper.map(mubm, ManufacturerServiceModel.class));
        return REDIRECT_TO_MANUFACTURER_UPDATE;
    }

    @PageTitle(name = "Manufacturer")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER')")
    @GetMapping(GET_MAPPING_MANUFACTURER_ALL)
    public String allManufacturer() {
        return MANUFACTURER_ALL_VIEW;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping(GET_MAPPING_MANUFACTURER_DELETE)
    public String deleteManufacturer(@PathVariable("manufacturerId") String manufacturerId) {
        this.manufacturerService.deleteManufacturer(manufacturerId);
        return REDIRECT_TO_MANUFACTURER_UPDATE;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping(POST_MAPPING_MANUFACTURER_SAVE)
    public String saveManufacturer(@ModelAttribute("smbm") ManufacturerSaveBindingModel smbm,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.smbm", smbm);
            redirectAttributes.addFlashAttribute("smbm", smbm);
            return REDIRECT_TO_MANUFACTURER_UPDATE;
        }
        this.manufacturerService.saveManufacturer(
                this.modelMapper.map(smbm, ManufacturerServiceModel.class));
        return REDIRECT_TO_MANUFACTURER_UPDATE;
    }

    @ExceptionHandler({ManufacturerIsNotExistException.class, UpdateManufacturerException.class,
            ManufacturerIsNotExistException.class})
    public ModelAndView handleManufacturerException(CustomBaseException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msgError", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
