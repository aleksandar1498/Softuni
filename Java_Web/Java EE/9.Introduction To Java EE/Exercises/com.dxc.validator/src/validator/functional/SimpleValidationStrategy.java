package validator.functional;

public interface SimpleValidationStrategy<T> extends ValidationStrategy<T> {
    boolean validate(T data);
}
