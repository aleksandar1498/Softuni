package com.interview.preparation.javarevisited.vendingMachine.models.repositories;

import com.interview.preparation.javarevisited.vendingMachine.interfaces.Repository;

import javax.sound.sampled.Line;
import java.util.*;

public  abstract class BaseRepository<T> implements Repository<T> {
    private Map<String,T> data;
    protected BaseRepository() {
        this.data = new TreeMap<String,T>();
    }

    @Override
    public void add(String key, T element) {
        this.data.put(key,element);
    }

    @Override
    public T find(T element) {
        return this.data.values().stream().filter(x -> x.equals(element)).findFirst().orElse(null);
    }

    @Override
    public Map<String, T> getAll() {
        return Collections.unmodifiableMap(this.data);
    }
}
