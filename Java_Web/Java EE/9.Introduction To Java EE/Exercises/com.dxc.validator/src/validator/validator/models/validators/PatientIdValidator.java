package validator.validator.models.validators;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import validator.validator.errors.Error;
import validator.validator.interfaces.ValidationRule;
import validator.validator.models.rules.StringConstraintRule;
import validator.validator.models.rules.StringFormatRule;

public final class PatientIdValidator extends ValidatorBase<String> {
    private static final String PATIENT_ID_FORMAT = "PAT[0-9]{3}";
    private static final String IDENTIFIER = "PAT_ID";
    private static Set<ValidationRule> rules;

    static {
        rules = new LinkedHashSet<>() {
            {
                add(new StringConstraintRule(4, 8));
                add(new StringFormatRule(PATIENT_ID_FORMAT));
            }
        };
    }

    public PatientIdValidator() {
        super(IDENTIFIER, rules);
    }

    public List<Error> validate(final String obj) {
        return super.validate(obj, rules);
    }

}
