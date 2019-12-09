package validator.validator.models.validators;

import validator.validator.interfaces.ValidationRule;
import validator.validator.models.rules.StringConstraintRule;
import validator.validator.models.rules.StringFormatRule;

import java.util.LinkedHashSet;
import java.util.Set;

public class DoctorIdValidator extends ValidatorBase<String>{
    private static Set<ValidationRule> rules;

    static {
        rules = new LinkedHashSet<>(){{
            add(new StringConstraintRule(4,6));
            add(new StringFormatRule("DOC[0-9]{3}"));
        }};
    }
    public DoctorIdValidator() {
        super("DOC_ID", rules);
    }
}
