package validator.validator.models.rules;

import validator.validator.errors.ErrorType;

public class StringEmptinessRule extends EmptinessRule<String> {
    @Override
    public boolean validate(String arg, Object... params) {
        return !arg.isEmpty();
    }

    @Override
    public ErrorType getError() {
        return ErrorType.EMPTY;
    }

    @Override
    public Object[] getParams(){
        return new Object[0];
    }
}
