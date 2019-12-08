package validator.validator.models.validators;


import validator.functional.Error;
import validator.validator.interfaces.ValidationRule;
import validator.validator.interfaces.Validator;
import validator.validator.models.rules.simple.SimpleValidationRule;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class ValidatorBase<T> implements Validator<T> {
    private Set<ValidationRule> rules;
    private final String identifier;

    protected ValidatorBase(String identifier,Set<ValidationRule> rules) {
        this.identifier = identifier;
        this.setRules(rules);
    }
    protected ValidatorBase(String identifier) {
        this.identifier = identifier;
        this.setRules(new LinkedHashSet<>());
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setRules(Set<ValidationRule> rules) {
        this.rules = rules;
    }

    @Override
    public void addRule(ValidationRule rule) {
        this.rules.add((SimpleValidationRule)rule);
    }

    public List<Error> validate(T obj) {
        ValidationRule<T> dataValidation = null;

        List<Error> errors = new ArrayList<>();
        for (ValidationRule rule : rules) {
            dataValidation = rule;
            if (!dataValidation.validate(obj)) {
                errors.add(new Error(dataValidation.getMessage()));
            }
        }
        return errors;
    }
}
