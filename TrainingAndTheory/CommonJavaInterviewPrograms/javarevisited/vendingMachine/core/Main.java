package com.interview.preparation.javarevisited.vendingMachine.core;

import com.interview.preparation.javarevisited.vendingMachine.enums.Coin;
import com.interview.preparation.javarevisited.vendingMachine.interfaces.Repository;
import com.interview.preparation.javarevisited.vendingMachine.models.VendingMachine;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Coke;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Product;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Soda;
import com.interview.preparation.javarevisited.vendingMachine.models.repositories.CoinRepository;
import com.interview.preparation.javarevisited.vendingMachine.models.repositories.ProductRepository;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.deposit(Coin.DIME);
        vendingMachine.deposit(Coin.DIME);
        vendingMachine.deposit(Coin.DIME);
        vendingMachine.load(new Coke());
        vendingMachine.deposit(Coin.NICKEL);
        vendingMachine.deposit(Coin.NICKEL);
        vendingMachine.deposit(Coin.PENNY);
        vendingMachine.deposit(Coin.PENNY);
        vendingMachine.deposit(Coin.PENNY);
        vendingMachine.terminate();
    }
}
