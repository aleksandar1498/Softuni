package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class CustomersController {
    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all/ascending")
    @ResponseBody
    public String showAllCustomersInAscendingOder() {
        return this.customerService.getAll().toString();
    }
}
