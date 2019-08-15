package com.cardealer.cardealer.services;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllInAscendingOrderByDate();
    void saveCustomer(CustomerBindingModel customer);
}
