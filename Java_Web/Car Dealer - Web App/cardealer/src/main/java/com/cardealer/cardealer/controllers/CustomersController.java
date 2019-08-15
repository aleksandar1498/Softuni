package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;
import com.cardealer.cardealer.repositories.CustomerRepository;
import com.cardealer.cardealer.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.sql.Date;

@Controller
@RequestMapping("/customers")
public class CustomersController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public CustomersController(CustomerService customerService, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all/ascending")
    @ResponseBody
    public String showAllCustomersInAscendingOder() {
        return this.customerService.getAllInAscendingOrderByDate().toString();
    }
    @GetMapping("/all/save")
    public String saveCustomer() {
        CustomerBindingModel customer = new CustomerBindingModel();
        customer.setId(BigInteger.valueOf(22212211));
        customer.setBirthDate(Date.valueOf("1990-10-04"));
        customer.setName("Alex");
        customer.setIsYoungDriver(0);
        System.out.println();
        this.customerService.saveCustomer(customer);
        return "saved";
    }
}
