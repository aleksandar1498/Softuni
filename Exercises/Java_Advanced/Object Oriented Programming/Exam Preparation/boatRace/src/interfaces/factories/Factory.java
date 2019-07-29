package interfaces.factories;

public interface Factory<T> {
    T build(String[] args);
}
