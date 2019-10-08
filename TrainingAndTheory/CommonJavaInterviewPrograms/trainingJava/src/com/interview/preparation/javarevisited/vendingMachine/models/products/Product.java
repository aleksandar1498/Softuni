package com.interview.preparation.javarevisited.vendingMachine.models.products;

import com.interview.preparation.javarevisited.vendingMachine.interfaces.Valuable;

public abstract class Product implements Valuable {

    private double price;

    Product( double price) {
        this.setPrice(price);
    }



    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price Cannot be less then 0");
        }
        this.price = price;
    }
}
