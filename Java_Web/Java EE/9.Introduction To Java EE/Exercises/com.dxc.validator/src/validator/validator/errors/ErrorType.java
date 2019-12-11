package validator.validator.errors;

public enum ErrorType {
    EMPTY("is empty"), NOT_IN_RANGE("is not in the needed range"), NULL("is empty"), BEFORE("should be before"), AFTER(
            "is after"), IS_MORE("is more than the predefined limit"), IS_LESS(
                    "is less than the predefined limit"), FORMAT("is not in the format predefined");

    private String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
