package validator.validator.models.rules;

import validator.validator.errors.Error;
import validator.validator.errors.ErrorType;

import java.util.regex.Pattern;

public class StringFormatRule extends FormatRule<String> {
    private String regex;

    public StringFormatRule(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean validate(String arg, Object... params) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(arg).matches();
    }

    @Override
    public ErrorType getError() {
        return ErrorType.FORMAT;
    }

    @Override
    public Object[] getParams() {
        return new Object[]{regex};
    }
}
