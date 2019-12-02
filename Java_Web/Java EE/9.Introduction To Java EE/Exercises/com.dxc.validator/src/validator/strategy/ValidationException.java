package validator;

import java.util.List;
import java.util.Map;

public class ValidationException extends IllegalArgumentException {
    private Map<DoctorValidationType, List<Error>> root;
    public ValidationException(Map<DoctorValidationType, List<Error>> root) {
        super();
        this.root = root;
    }

    public Map<DoctorValidationType, List<Error>> getRoot() {
        return root;
    }
}
