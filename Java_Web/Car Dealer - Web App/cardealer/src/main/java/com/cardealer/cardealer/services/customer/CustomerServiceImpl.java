package com.cardealer.cardealer.services.customer;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.entities.Customer;
import com.cardealer.cardealer.models.CustomerBindingModel;
import com.cardealer.cardealer.repositories.CarsRepository;
import com.cardealer.cardealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final CarsRepository carsRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, CarsRepository carsRepository) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.carsRepository = carsRepository;
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
    public String getTotalSalesInfoByCustomer(Long id){
        List<Car> cars = this.customerRepository.findAllCarsBoughtByUser(id);
        Customer customer = this.customerRepository.findById(id).orElse(null);
        //TODO discount needs to be added
        if(customer == null){
            return "<h1>The user with id "+id+" was not found </h1>";
        }

        double totalSpentMoney = 0;
        for (Car car : cars) {
            totalSpentMoney+=this.carsRepository.getTotalPrice(car.getCarId());

        }
        return String.format("%s-%d-%.2f",customer.getName(),cars.size(),totalSpentMoney);
    }
}
