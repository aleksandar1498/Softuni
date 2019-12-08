package validator.validator.models.rules.simple;

public class StringEmptinessRule extends EmptinessRule<String> {
    @Override
    public boolean validate(String arg, Object... params) {
        return !arg.isEmpty();
    }

    @Override
    public String getMessage() {
        return "cannot be empty";
    }
}
