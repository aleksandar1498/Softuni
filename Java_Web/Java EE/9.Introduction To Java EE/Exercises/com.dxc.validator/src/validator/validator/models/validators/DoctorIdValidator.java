package validator.validator.models.validators;

import validator.validator.interfaces.ValidationRule;
import validator.validator.models.rules.StringConstraintRule;
import validator.validator.models.rules.StringFormatRule;

import java.util.LinkedHashSet;
import java.util.Set;

public class DoctorIdValidator extends ValidatorBase<String>{
    private static final String DOCTOR_ID_FORMAT = "DOC[0-9]{3}";
    private static final String IDENTIFIER = "DOC_ID";
    private static Set<ValidationRule> rules;

    static {
        rules = new LinkedHashSet<>(){{
            add(new StringConstraintRule(4,6));
            add(new StringFormatRule(DOCTOR_ID_FORMAT));
        }};
    }
    public DoctorIdValidator() {
        super(IDENTIFIER, rules);
    }
}
