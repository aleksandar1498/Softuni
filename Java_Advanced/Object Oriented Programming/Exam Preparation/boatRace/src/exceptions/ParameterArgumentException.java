package exceptions;

public class ParameterArgumentException extends Exception {
    public ParameterArgumentException(String message) {
        super(message+" must be a positive integer.");
    }
}
