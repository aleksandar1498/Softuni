package validator.functional;

public interface ParameterizedValidationStrategy<T> extends ValidationStrategy<T>  {
    boolean validate(T data,Object ...params);
}
