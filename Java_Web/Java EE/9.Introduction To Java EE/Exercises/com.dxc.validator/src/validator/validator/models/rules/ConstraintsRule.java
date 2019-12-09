package validator.validator.models.rules;

import validator.validator.interfaces.ValidationRule;


/**
 * Abstract class for limits such as IN_RANGE OUT_RANGE AFTER BEFORE
 * @param <T>
 */
public abstract class ConstraintsRule<T> implements ValidationRule<T> {

}
