package validator.functional;

public interface ValidationStrategy<T> {
    boolean validate(T data);
    String getMessage();
}
