package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;
import com.cardealer.cardealer.repositories.CustomerRepository;
import com.cardealer.cardealer.services.customer.CustomerService;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.DateFormatter;
import java.math.BigInteger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public ModelAndView ShowAddNewUserPage(ModelAndView modelAndView){
        modelAndView.setViewName("/customers/AddUser.html");
        modelAndView.addObject("customer",new CustomerBindingModel());
        return modelAndView;
    }
    @PostMapping("/add")
    public String addNewUser(CustomerBindingModel customerBindingModel){
         Date d = customerBindingModel.getBirthDate();
        Date current = new Date();
        System.out.println();
        if(current.getTime()-d.getTime() >= Long.valueOf("568025136000")){
            customerBindingModel.setIsYoungDriver(1);
        }else{
            customerBindingModel.setIsYoungDriver(0);
        }
        try {
            this.customerService.saveCustomer(customerBindingModel);
        }catch (IllegalArgumentException ex){
            return "redirect:/customers/add";
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView ShowEditUserPage(@PathVariable("id") Long id, ModelAndView modelAndView) throws ParseException {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        if(customer == null){
            modelAndView.addObject("id",id);
            modelAndView.setViewName("/customers/UserNotFound.html");
        }else{
            modelAndView.setViewName("/customers/EditUser.html");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            modelAndView.addObject("currentBirthDate",format.parse(customer.getBirthDate().toString()));
            modelAndView.addObject("customer",customer);
        }
       return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, ModelAndView modelAndView){
       /* Date d = customerBindingModel.getBirthDate();
        Date current = new Date();
        System.out.println();
        if(current.getTime()-d.getTime() >= Long.valueOf("568025136000")){
            customerBindingModel.setIsYoungDriver(1);
        }else{
            customerBindingModel.setIsYoungDriver(0);
        }
        try {
            this.customerService.saveCustomer(customerBindingModel);
        }catch (IllegalArgumentException ex){
            return "redirect:/customers/add";
        }*/
        return "redirect:/";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String showDetailsAboutCustomerSales(@PathVariable("id") Long id){
        List<String> data = Arrays.asList(this.customerService.getSalesInfoByCustomer(id).split("-"));
        return data.toString();
    }
    @GetMapping("/all/ascending")
    public ModelAndView showAllCustomersInAscendingOder(ModelAndView modelAndView) {
        List<Customer> customers = this.customerService.getAllInAscendingOrderByDate();
        modelAndView.addObject("customers",customers);
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

}
