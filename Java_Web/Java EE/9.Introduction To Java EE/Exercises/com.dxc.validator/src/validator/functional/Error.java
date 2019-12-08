package validator.functional;

import java.util.List;

public class Error {
    private String message;


    public Error(final String message) {
        this.message = message;
    }



    public String getErrorKey() {
        return message;
    }

    public void setErrorKey(final String message) {
        this.message = message;
    }
}
