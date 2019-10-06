package com.interview.preparation.javarevisited.vendingMachine.interfaces;

import java.util.List;
import java.util.Map;

public interface Repository<T> {
    void add(String key,T element);
    T find(T element);
    Map<String, List<T>> getAll();
    Map<String, List<T>> clearAll();
}
