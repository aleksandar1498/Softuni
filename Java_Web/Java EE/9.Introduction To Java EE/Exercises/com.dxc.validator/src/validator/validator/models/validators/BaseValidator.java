package validator.validator.models.validators;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import validator.validator.errors.Error;
import validator.validator.exceptions.ValidationException;
import validator.validator.interfaces.ValidationRule;

public class BaseValidator {
    private Map<String, List<Error>> errors;

    public BaseValidator() {
        this.errors = new LinkedHashMap<>();
    }

    public void validate(final String identifier, final Object obj, final ValidationRule rule) {
        if (!rule.validate(obj)) {
            if (!this.errors.containsKey(identifier)) {
                this.errors.put(identifier, new ArrayList<>());
            }
            this.errors.get(identifier).add(new Error(rule.getError(), rule.getParams()));
        }
    }

    public void checkValidated() {
        if (this.errors.size() > 0) {
            throw new ValidationException(errors);
        }
    }
}
