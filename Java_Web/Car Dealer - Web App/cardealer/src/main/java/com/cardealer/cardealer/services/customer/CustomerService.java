package com.cardealer.cardealer.services.customer;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllInAscendingOrderByDate();
    void saveCustomer(CustomerBindingModel customer);

    List<Customer> getAllInDescendingOrderByDate();
}