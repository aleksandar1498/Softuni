package validator.validator.models.validators;

import validator.functional.Error;
import validator.validator.interfaces.Validator;
import validator.validator.interfaces.ValidatorContainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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
    public Map<String, List<Error>> execute() {
        Map<String,List<Error>> errors = new LinkedHashMap<>();
        System.out.println();
        for(var validator : this.validators.entrySet()){
            if(validator.getValue().size() > 0){
                errors.put(validator.getKey(),validator.getValue());
            }
        }
        return errors;
    }
}
