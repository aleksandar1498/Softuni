package validator.validator.models.validators;

import validator.validator.exceptions.ValidationException;
import validator.validator.interfaces.ValidatorContainer;
import validator.validator.errors.Error;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ValidatorContainerImpl implements ValidatorContainer {
    private Map<String,List<Error>> validators;

    public ValidatorContainerImpl() {
        this.validators = new LinkedHashMap<>();
    }

    @Override
    public void addValidator(String identifier, List<Error> errors) {
        this.validators.put(identifier,errors);
    }

    @Override
    public void checkValidated() {
        Map<String,List<Error>> errors = new LinkedHashMap<>();
        for(var validator : this.validators.entrySet()){
            if(validator.getValue().size() > 0){
                errors.put(validator.getKey(),validator.getValue());
            }
        }
        if(errors.size() > 0){
            throw new ValidationException(errors);
        }
    }
}
