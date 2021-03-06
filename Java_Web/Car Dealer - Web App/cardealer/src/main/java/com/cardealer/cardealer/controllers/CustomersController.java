package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;
import com.cardealer.cardealer.repositories.CustomerRepository;
import com.cardealer.cardealer.services.customer.CustomerService;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.DateFormatter;
import javax.validation.Valid;
import java.math.BigInteger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/add")
    public String ShowAddNewUserPage(@ModelAttribute("customer") CustomerBindingModel customer) {
     return "/customers/AddUser.html";
    }

    @PostMapping("/add")
    public String addNewUser(@Valid @ModelAttribute("customer") CustomerBindingModel customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println();
            return "/customers/AddUser.html";
        }
        this.customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView ShowEditUserPage(@PathVariable("id") Long id, ModelAndView modelAndView) throws ParseException {
        Customer customer = this.customerRepository.findById(id).orElse(null);

        if (customer == null) {
            modelAndView.addObject("id", id);
            modelAndView.setViewName("/customers/UserNotFound.html");
        } else {
            modelAndView.setViewName("/customers/EditUser.html");
            modelAndView.addObject("currentBirthDate", customer.getBirthDate());
            modelAndView.addObject("customer", customer);
        }
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editUser(CustomerBindingModel customerBindingModel) {
        try {
            this.customerService.editCustomer(customerBindingModel);

        } catch (IllegalArgumentException exception) {
            return "redirect:/edit/" + customerBindingModel.getId();
        }
        return "redirect:/";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String showDetailsAboutCustomerSales(@PathVariable("id") Long id) {
        List<String> data = Arrays.asList(this.customerService.getSalesInfoByCustomer(id).split("-"));
        return data.toString();
    }

    @GetMapping("/all/ascending")
    public ModelAndView showAllCustomersInAscendingOder(ModelAndView modelAndView) {
        List<Customer> customers = this.customerService.getAllInAscendingOrderByDate();
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("/customers/MainCustomer.html");
        return modelAndView;

    }

    @GetMapping("/all/descending")
    @ResponseBody
    public String showAllCustomersInDescendingOder() {
        List<Customer> customers = this.customerService.getAllInDescendingOrderByDate();
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customers) {
            stringBuilder.append(customer).append("</br>");
        }
        return stringBuilder.toString();

    }

    private ModelAndView redirect(String address) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:"+address);
        return modelAndView;
    }




}
