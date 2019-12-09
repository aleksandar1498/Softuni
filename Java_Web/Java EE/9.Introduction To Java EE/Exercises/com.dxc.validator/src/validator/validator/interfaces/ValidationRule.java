package validator.validator.interfaces;

import validator.validator.errors.ErrorType;

public interface ValidationRule<T> {
    boolean validate(T arg, Object... params);
    ErrorType getError();
    Object[] getParams();
}
