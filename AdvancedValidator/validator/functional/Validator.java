package validator.functional;

import validator.strategy.DoctorValidationType;
import validator.strategy.Error;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @param <T> is the placeholder for the type
 */
public class Validator<T> {

    private final String identifier;



    private Set<ValidationStrategy<T>> strategies;
    //private final List<String> exceptions = new ArrayList<>();


    public Validator(String identifier, Set<ValidationStrategy<T>> strategies) {
        this.identifier = identifier;
        this.strategies = strategies;

    }

    public List<Error> validate(T obj) {
        ValidationStrategy<T> dataValidation = null;

        List<Error> errors = new ArrayList<>();
        for (ValidationStrategy<T> strategy : strategies) {
            dataValidation = strategy;
            if (!dataValidation.validate(obj)) {
                errors.add(new Error(dataValidation.getMessage()));
            }


        }
        return errors;
    }

    public String getIdentifier() {
        return identifier;
    }




}
