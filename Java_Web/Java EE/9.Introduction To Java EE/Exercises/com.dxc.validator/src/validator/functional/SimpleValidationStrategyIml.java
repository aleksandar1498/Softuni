package validator.functional;

public enum SimpleValidationStrategyIml implements SimpleValidationStrategy<Object> {
    NULL("Cannot be null"){
        @Override
        public boolean validate(Object data) {
            return data != null;
        }
    },
    EMPTY("Cannot be empty"){
        @Override
        public boolean validate(Object data) {
            return false;
        }
    };

    private String message;
    SimpleValidationStrategyIml(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
