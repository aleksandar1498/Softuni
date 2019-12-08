package validator.validator.models.rules.parameterized;

import validator.validator.models.rules.parameterized.ParameterizedValidationRule;
import validator.validator.models.rules.simple.SimpleValidationRule;

/**
 * Abstract class for limits such as IN_RANGE OUT_RANGE AFTER BEFORE
 * @param <T>
 */
public abstract class ConstraintsRule<T> extends SimpleValidationRule<T> {
}
