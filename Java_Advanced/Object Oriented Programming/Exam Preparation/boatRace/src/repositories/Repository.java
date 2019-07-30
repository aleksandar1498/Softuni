package repositories;

import exceptions.NonExistantModelException;

public interface Repository<T> {
    boolean add(String model, T element);
    T get(String model) throws NonExistantModelException;
    boolean contains(String model);
}
