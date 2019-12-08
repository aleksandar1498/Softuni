package validator.validator.models.rules.simple;

import validator.validator.models.rules.parameterized.ConstraintsRule;

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
    public String getMessage() {
        return String.format("The passed argument is not between %d and %d",this.lowLimit,this.topLimit);
    }
}
