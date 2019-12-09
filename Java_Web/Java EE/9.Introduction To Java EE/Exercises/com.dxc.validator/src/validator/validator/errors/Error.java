package validator.validator.errors;

import java.util.Arrays;

public class Error {


    private ErrorType errorKey;
    private Object[] errorParams;

    public Error(final ErrorType errorKey, final Object ... errorParams) {
        this.errorParams = errorParams;
        this.errorKey = errorKey;
    }

    public Object[] getErrorValue() {
        return errorParams;
    }

    public void setErrorValue(final Object[] errorValues) {
        this.errorParams = errorValues;
    }

    public ErrorType getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(final ErrorType errorKey) {
        this.errorKey = errorKey;
    }

    @Override
    public String toString() {
        return String.format("%s %s",errorKey,(errorParams.length > 0)? Arrays.asList(errorParams).toString(): "");
    }
}
