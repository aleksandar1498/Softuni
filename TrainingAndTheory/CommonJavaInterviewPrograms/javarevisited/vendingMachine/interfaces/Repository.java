package com.interview.preparation.javarevisited.vendingMachine.interfaces;

import java.util.Map;

public interface Repository<T> {
    void add(String key,T element);
    T find(T element);
    Map<String,T> getAll();
}
