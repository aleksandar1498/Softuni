package com.cardealer.cardealer.services.customer;

import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;
import com.cardealer.cardealer.models.SaleModel;
import com.cardealer.cardealer.repositories.CarsRepository;
import com.cardealer.cardealer.repositories.CustomerRepository;
import com.cardealer.cardealer.repositories.SalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final CarsRepository carsRepository;
    private final SalesRepository salesRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, CarsRepository carsRepository, SalesRepository salesRepository) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.carsRepository = carsRepository;
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Customer> getAllInAscendingOrderByDate() {
        return this.customerRepository.findAllOrderedByDateAsc();
    }

    @Override
    public void saveCustomer(CustomerBindingModel customer) {
        this.customerRepository.save(modelMapper.map(customer,Customer.class));
    }

    @Override
    public List<Customer> getAllInDescendingOrderByDate() {
        return this.customerRepository.findAllOrderedByDateDesc();
    }

    @Override
    public String getSalesInfoByCustomer(Long id){
        List<SaleModel> sales = this.salesRepository.getAllSalesByGivenCustomerId(id);
        Customer customer = this.customerRepository.findById(id).orElse(null);
        //TODO discount needs to be added
        if(customer == null){
            return "<h1>The user with id "+id+" was not found </h1>";
        }

        double totalSpentMoney = 0;
        for (SaleModel saleModel : sales) {
            System.out.println(this.carsRepository.getTotalPrice(saleModel.getCar().getCarId()));
            totalSpentMoney+=this.carsRepository.getTotalPrice(saleModel.getCar().getCarId())*(1-saleModel.getDiscount());

        }
        return String.format("%s-%d-%.2f",customer.getName(),sales.size(),totalSpentMoney);
    }
}
