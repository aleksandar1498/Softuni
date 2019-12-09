package validator.validator.models.rules;

import validator.validator.errors.ErrorType;

public class StringConstraintRule extends ConstraintsRule<String> {
    private  int lowLimit;
    private int topLimit;

    public StringConstraintRule(int lowLimit, int topLimit) {
        this.lowLimit = lowLimit;
        this.topLimit = topLimit;
    }

    @Override
    public boolean validate(String arg, Object... params) {
        return arg.length() > lowLimit && arg.length() < topLimit;
    }

    @Override
    public ErrorType getError() {
        return ErrorType.NOT_IN_RANGE;
    }
    @Override
    public Object[] getParams(){
        return new Object[]{this.lowLimit,this.topLimit};
    }
}
