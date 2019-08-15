package com.cardealer.cardealer.services;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;
import com.cardealer.cardealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Customer> getAllInAscendingOrderByDate() {
         return this.customerRepository.findAll();
    }

    @Override
    public void saveCustomer(CustomerBindingModel customer) {
        System.out.println();
        this.customerRepository.save(modelMapper.map(customer,Customer.class));
    }
}
