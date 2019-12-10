package validator.validator.exceptions;



import java.util.List;
import java.util.Map;
import validator.validator.errors.Error;

public class ValidationException extends RuntimeException{
    private Map<String,List<Error>> root;
    public ValidationException(Map<String,List<Error>> root) {
        super();
        this.root = root;
    }

    public Map<String,List<Error>> getRoot() {
        return root;
    }
}
