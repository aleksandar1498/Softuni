package validator.validator.models.rules.simple;

import java.text.Format;
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
    public String getMessage() {
        return "The format is not in "+regex;
    }
}
