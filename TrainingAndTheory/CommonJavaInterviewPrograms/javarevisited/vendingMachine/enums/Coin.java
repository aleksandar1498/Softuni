package com.interview.preparation.javarevisited.vendingMachine.enums;

public enum Coin {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTYFIVE(25);
    int val = 0;
    Coin(int val){
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}
