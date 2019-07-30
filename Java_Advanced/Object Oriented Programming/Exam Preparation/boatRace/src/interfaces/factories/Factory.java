package interfaces.factories;

import exceptions.NonExistantModelException;

import java.lang.reflect.InvocationTargetException;

public interface Factory<T> {
    T build(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NonExistantModelException;
}
