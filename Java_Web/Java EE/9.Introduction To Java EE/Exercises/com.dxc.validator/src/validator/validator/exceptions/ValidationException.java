package validator.validator.exceptions;

import validator.strategy.Error;

import java.util.List;

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
