package com.interview.preparation.javarevisited.vendingMachine.core;

import com.interview.preparation.javarevisited.vendingMachine.enums.Coin;
import com.interview.preparation.javarevisited.vendingMachine.interfaces.Repository;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Coke;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Product;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Soda;
import com.interview.preparation.javarevisited.vendingMachine.models.repositories.CoinRepository;
import com.interview.preparation.javarevisited.vendingMachine.models.repositories.ProductRepository;

public class Main {
    public static void main(String[] args) {
        Product coke = new Coke();
        System.out.println(coke.getPrice());
        Product soda = new Soda();
        System.out.println(soda.getPrice());
        Coin coin = Coin.ONE;
        Repository<Product> repository = new ProductRepository();
        repository.add(coke.getClass().getSimpleName(),coke);
        repository.add(coke.getClass().getSimpleName(),soda);
        System.out.println(repository.getAll());
    }
}
