package repositories;

import exceptions.NonExistantModelException;

import java.util.Map;

public interface Repository<T> {
    boolean add(String model, T element);
    T get(String model) throws NonExistantModelException;
    boolean contains(String model);
    int count();
    void clearRepo();
    Map<String, T> getEntries();
}
