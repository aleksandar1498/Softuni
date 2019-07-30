package exceptions;

public class ModelArgumentException extends Exception {
    public ModelArgumentException(String message) {
        super("Model's name must be at least "+message+" symbols long");
    }
}
