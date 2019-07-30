package models;

import exceptions.NonExistantModelException;
import repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryImpl<T> implements Repository<T> {
    private Map<String,T> entries;

    public RepositoryImpl() {
        this.entries = new LinkedHashMap<>();
    }

    @Override
    public void add(String model,T element) {
        this.getEntries().put(model, element);
    }

    @Override
    public T get(String model) throws NonExistantModelException {
        if(this.getEntries().containsKey(model)){
            return this.getEntries().get(model);
        }
       throw new NonExistantModelException("");
    }

    @Override
    public boolean contains(String model) {
        return this.getEntries().containsKey(model);
    }

    private Map<String, T> getEntries() {
        return this.entries;
    }
}
