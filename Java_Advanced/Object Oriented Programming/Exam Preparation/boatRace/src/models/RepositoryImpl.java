package models;

import exceptions.NonExistantModelException;
import repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryImpl<T> implements Repository<T> {
    private Map<String, T> entries;

    public RepositoryImpl() {
        this.entries = new LinkedHashMap<>();
    }

    @Override
    public boolean add(String model, T element) {
        if (!this.getEntries().containsKey(model)) {
            this.getEntries().put(model, element);
            return true;
        }
        return false;
    }

    @Override
    public T get(String model) throws NonExistantModelException {
        if (this.getEntries().containsKey(model)) {
            return this.getEntries().get(model);
        }
        throw new NonExistantModelException("");
    }

    @Override
    public boolean contains(String model) {
        return this.getEntries().containsKey(model);
    }

    @Override
    public int count() {
        return this.getEntries().size();
    }

    @Override
    public void clearRepo() {
        this.entries.clear();
    }


    @Override
    public Map<String, T> getEntries() {
        return this.entries;
    }
}
