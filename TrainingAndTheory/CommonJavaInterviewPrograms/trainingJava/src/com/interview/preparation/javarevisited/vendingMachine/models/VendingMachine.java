package com.interview.preparation.javarevisited.vendingMachine.models;

import com.interview.preparation.javarevisited.vendingMachine.enums.Coin;
import com.interview.preparation.javarevisited.vendingMachine.interfaces.Depositable;
import com.interview.preparation.javarevisited.vendingMachine.interfaces.Loadable;
import com.interview.preparation.javarevisited.vendingMachine.interfaces.Refundable;
import com.interview.preparation.javarevisited.vendingMachine.interfaces.Repository;
import com.interview.preparation.javarevisited.vendingMachine.models.products.Product;
import com.interview.preparation.javarevisited.vendingMachine.models.repositories.CoinRepository;
import com.interview.preparation.javarevisited.vendingMachine.models.repositories.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;

public class VendingMachine implements Depositable, Loadable<Product>, Refundable {
    Repository<Product> products;
    Repository<Coin> depositedCoins;
    private double currentBalance;
    private double neededMoney;
    public VendingMachine() {
        this.products = new ProductRepository();
        this.depositedCoins = new CoinRepository();
        this.currentBalance = 0;
        neededMoney = 0;
    }
    public void terminate(){
        if(neededMoney == 0){
            System.out.println("You have not bought nothing");
            System.out.println(refund());
            return;
        }
        if(this.currentBalance < this.neededMoney){
            throw new IllegalStateException("The user does not have enough money");
        }else if(this.currentBalance == this.neededMoney){
            System.out.println("The user completed his transaction, the inserted coins corresponded to the neededMoney");
            return;
        }
        System.out.println("The user completed his transaction");
        System.out.printf("Return coins : %s%n",this.change(this.currentBalance,this.neededMoney));
        this.currentBalance = 0;
        this.neededMoney = 0;
    }

    @Override
    public Map<Coin, Integer> change(double currentBalance, double neededMoney) {
        Map<Coin,Integer> coins = new HashMap<>();
        double remainder = currentBalance-neededMoney;
            if(remainder >= Coin.QUARTER.getVal()){
                int returnedCoins = (int) Math.floor(remainder / Coin.QUARTER.getVal());
                coins.put(Coin.QUARTER,returnedCoins);
                remainder-=returnedCoins*Coin.QUARTER.getVal();
            }
            if(remainder >= Coin.DIME.getVal()){
                int returnedCoins = (int) Math.floor(remainder / Coin.DIME.getVal());
                coins.put(Coin.DIME,returnedCoins);
                remainder-=returnedCoins*Coin.DIME.getVal();
            }
            if(remainder >= Coin.NICKEL.getVal()){
                int returnedCoins = (int) Math.floor(remainder / Coin.NICKEL.getVal());
                coins.put(Coin.NICKEL,returnedCoins);
                remainder-=returnedCoins*Coin.NICKEL.getVal();
            }
            if(remainder >= Coin.PENNY.getVal()){
                int returnedCoins = (int) Math.floor(remainder / Coin.PENNY.getVal());
                coins.put(Coin.PENNY,returnedCoins);
                remainder-=returnedCoins*Coin.PENNY.getVal();
            }

        return coins;
    }

    @Override
    public void deposit(Coin coin) {
        this.currentBalance += coin.getVal();
        this.depositedCoins.add(coin.name(),coin);
    }

    @Override
    public void load(Product element) {
        this.neededMoney+=element.getPrice();
        this.products.add(element.getClass().getSimpleName(),element);
    }

    @Override
    public List<Coin> refund() {
        System.out.println(currentBalance + " has been refunded to the user");
        currentBalance = 0;
        return this.depositedCoins.clearAll().values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

}
