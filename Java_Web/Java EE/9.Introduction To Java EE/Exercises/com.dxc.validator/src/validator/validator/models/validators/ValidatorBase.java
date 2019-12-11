package validator.validator.models.validators;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import validator.validator.errors.Error;
import validator.validator.interfaces.ValidationRule;
import validator.validator.interfaces.Validator;

public class ValidatorBase<T> implements Validator<T> {
    private Set<ValidationRule> rules;
    private final String identifier;

    ValidatorBase(final String identifier, final Set<ValidationRule> rules) {
        this.identifier = identifier;
        this.setRules(rules);
    }

    protected ValidatorBase(final String identifier) {
        this.identifier = identifier;
        this.setRules(new LinkedHashSet<>());
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setRules(final Set<ValidationRule> rules) {
        this.rules = rules;
    }

    @Override
    public void addRule(final ValidationRule rule) {
        this.rules.add(rule);
    }

    @Override
    public List<Error> validate(final T obj, final Set<ValidationRule> rules) {
        ValidationRule<T> dataValidation = null;

        final List<Error> errors = new ArrayList<>();
        for (final ValidationRule<T> rule : rules) {
            dataValidation = rule;
            if (!dataValidation.validate(obj)) {
                errors.add(new Error(dataValidation.getError(), dataValidation.getParams()));
            }
        }
        return errors;
    }

}
