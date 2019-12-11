package validator.validator.interfaces;

import java.util.List;
import java.util.Set;

import validator.validator.errors.Error;

public interface Validator<T> {
    String getIdentifier();

    void setRules(Set<ValidationRule> rules);

    void addRule(ValidationRule rule);

    List<Error> validate(T obj, Set<ValidationRule> rules);

}
