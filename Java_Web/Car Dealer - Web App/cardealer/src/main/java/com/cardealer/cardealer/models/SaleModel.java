package com.cardealer.cardealer.models;

import com.cardealer.cardealer.entities.Car;

public class SaleModel {
    private Car car;
    private Double discount;

    public SaleModel(Car car, Double discount) {
        this.car = car;
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
}
