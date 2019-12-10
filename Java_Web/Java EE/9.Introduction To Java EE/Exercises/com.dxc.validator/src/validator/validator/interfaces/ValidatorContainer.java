package validator.validator.interfaces;

import validator.validator.errors.Error;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public interface ValidatorContainer {
    void addValidator(String id,List<Error> errors);
    void checkValidated();
}
