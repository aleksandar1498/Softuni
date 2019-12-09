package validator.validator.models.validators;


import validator.validator.interfaces.ValidationRule;
import validator.validator.models.rules.StringConstraintRule;
import validator.validator.models.rules.StringFormatRule;
import java.util.LinkedHashSet;
import java.util.Set;

public class PatientIdValidator extends ValidatorBase<String> {
    private static Set<ValidationRule> rules;

    static {
        rules = new LinkedHashSet<>(){{
            add(new StringConstraintRule(4,8));
            add(new StringFormatRule("PAT[0-9]{3}"));
        }};
    }
    public PatientIdValidator() {
        super("PAT_ID", rules);
    }
}
