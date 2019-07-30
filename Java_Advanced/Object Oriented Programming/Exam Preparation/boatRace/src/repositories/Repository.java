package repositories;

import exceptions.NonExistantModelException;

public interface Repository<T> {
    void add(String model,T element);
    T get(String model) throws NonExistantModelException;
    boolean contains(String model);
}
