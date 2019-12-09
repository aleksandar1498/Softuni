package validator.validator.interfaces;


import validator.validator.errors.Error;
import java.util.List;
import java.util.Set;

public interface Validator<T> {
    String getIdentifier();
    void setRules(Set<ValidationRule> rules);
    void addRule(ValidationRule rule);
    List<Error> validate(T obj);
}
