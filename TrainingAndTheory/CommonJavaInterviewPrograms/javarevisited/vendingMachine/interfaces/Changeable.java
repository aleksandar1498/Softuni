package com.interview.preparation.javarevisited.vendingMachine.interfaces;

import com.interview.preparation.javarevisited.vendingMachine.enums.Coin;

import java.util.List;

public interface Changeable {
    void change(Coin coin);
    void change(List<Coin> coins);
}
