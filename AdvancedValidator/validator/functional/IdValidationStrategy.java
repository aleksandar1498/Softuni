package validator.functional;

import java.util.regex.Pattern;

public enum IdValidationStrategy implements ValidationStrategy<String> {
    NULL("Cannot be null"){
        @Override
        public boolean validate(String data) {
            return data != null;
        }
    },
    EMPTY("Cannot be empty"){
        @Override
        public boolean validate(String data) {
            return !data.isEmpty();
        }
    },
    FORMAT("Is not in format DOC111 | PAT111"){
        @Override
        public boolean validate(String data) {
            final String ID_PATTERN = "(DOC|PAT)[0-9]{3}";
            final Pattern pattern = Pattern.compile(ID_PATTERN);
            return pattern.matcher(data).matches();
        }
    };

    private String message;
    IdValidationStrategy(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
