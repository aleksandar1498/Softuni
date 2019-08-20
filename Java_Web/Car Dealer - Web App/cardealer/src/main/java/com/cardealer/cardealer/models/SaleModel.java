package com.cardealer.cardealer.models;

import com.cardealer.cardealer.entities.Car;
import com.cardealer.cardealer.entities.Customer;

public class SaleModel {
    private Car car;
    private Customer customer;
    private Double discount = 0.0;

    public SaleModel(Car car, Double discount) {
        this.car = car;
        this.discount = discount;
    }

    public SaleModel(Car car, Customer customer, Double discount) {
        this.car = car;
        this.customer = customer;
        this.discount = discount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public boolean isDiscounted(){
        return this.discount > 0.0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
