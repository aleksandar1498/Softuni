package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.Supplier;
import com.cardealer.cardealer.entities.SupplierParts;
import com.cardealer.cardealer.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;
    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = "/local")
    public ModelAndView showLocalSuppliers(ModelAndView modelAndView){
        List<SupplierParts> suppliers  = this.supplierService.getLocalSuppliersWithOfferedParts();
        modelAndView.addObject("suppliers",suppliers);
        //modelAndView.setViewName();
        return modelAndView;
    }
    @GetMapping(value = "/importers")
    public ModelAndView showImportedSuppliers(ModelAndView modelAndView){
        List<Supplier> suppliers  = this.supplierService.showImported();
        modelAndView.addObject("suppliers",suppliers);
       // modelAndView.setViewName();
        return modelAndView;
    }
}