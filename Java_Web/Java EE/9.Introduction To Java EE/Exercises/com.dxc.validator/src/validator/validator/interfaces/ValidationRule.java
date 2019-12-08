package validator.validator.interfaces;

public interface ValidationRule<T> {
    boolean validate(T arg, Object... params);
    String getMessage();
}
