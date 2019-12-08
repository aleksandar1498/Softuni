package validator.functional;

import validator.strategy.DoctorValidationType;
import validator.functional.Error;

import java.util.List;
import java.util.Map;

public class ValidationException extends IllegalArgumentException{
    private List<Error> root;
    public ValidationException(List<Error> root) {
        super();
        this.root = root;
    }

    public List<Error> getRoot() {
        return root;
    }
}
