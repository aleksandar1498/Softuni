package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.models.PartModel;
import com.cardealer.cardealer.services.parts.PartService;
import com.cardealer.cardealer.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/parts")
public class PartsController {
    private final SupplierService supplierService;
    private final PartService partService;
    @Autowired
    public PartsController(SupplierService supplierService, PartService partService) {
        this.supplierService = supplierService;
        this.partService = partService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showPartPage(@ModelAttribute PartModel partModel, @RequestParam(value = "quantity", defaultValue = "1") Integer quantity, ModelMap model) {
        partModel.setQuantity(quantity);
        model.addAttribute("suppliers",this.supplierService.getAll());
        return "/parts/AddPart.html";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPart(@Valid @ModelAttribute PartModel partModel, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/parts/add";
        }
        this.partService.addPart(partModel);
        return "redirect:/";
    }
}
