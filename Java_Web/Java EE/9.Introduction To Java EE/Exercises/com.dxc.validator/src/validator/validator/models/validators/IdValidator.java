package validator.validator.models.validators;

import validator.validator.interfaces.ValidationRule;
import java.util.Set;

public class IdValidator extends ValidatorBase<String> {
    public IdValidator(String identifier, Set<ValidationRule> rules) {
        super(identifier, rules);
    }

}
