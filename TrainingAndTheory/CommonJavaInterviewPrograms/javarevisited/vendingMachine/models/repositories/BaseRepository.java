package com.interview.preparation.javarevisited.vendingMachine.models.repositories;

import com.interview.preparation.javarevisited.vendingMachine.interfaces.Repository;

import java.util.*;

public  abstract class BaseRepository<T> implements Repository<T> {
    private Map<String,List<T>> data;
    protected BaseRepository() {
        this.data = new TreeMap<>();
    }

    @Override
    public void add(String key, T element) {
        if(!this.data.containsKey(key)){
            this.data.put(key,new ArrayList<>());
        }
        this.data.get(key).add(element);
    }

    @Override
    public T find(T element) {
        return this.data.entrySet().stream().flatMap(x -> x.getValue().stream()).filter(x -> x.equals(element)).findFirst().orElse(null);
    }

    @Override
    public Map<String, List<T>> getAll() {
        return Collections.unmodifiableMap(this.data);
    }

    @Override
    public Map<String, List<T>> clearAll() {
        Map<String, List<T>>  deleted = Map.copyOf(this.data);
        this.data.clear();
        return deleted;
    }
}
