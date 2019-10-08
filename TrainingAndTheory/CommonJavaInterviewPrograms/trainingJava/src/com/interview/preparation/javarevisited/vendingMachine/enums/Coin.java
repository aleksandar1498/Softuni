package com.interview.preparation.javarevisited.vendingMachine.enums;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);
    int val = 0;
    Coin(int val){
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}
