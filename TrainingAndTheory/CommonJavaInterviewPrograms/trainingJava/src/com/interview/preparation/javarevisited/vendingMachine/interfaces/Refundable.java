package com.interview.preparation.javarevisited.vendingMachine.interfaces;

import com.interview.preparation.javarevisited.vendingMachine.enums.Coin;

import java.util.List;
import java.util.Map;

public interface Refundable {
    List<Coin> refund();
    Map<Coin, Integer> change(double currentBalance, double neededMoney);
}
