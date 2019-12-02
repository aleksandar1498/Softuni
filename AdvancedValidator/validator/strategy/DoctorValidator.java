package validator.strategy;

import models.Doctor;

import java.util.*;

public class DoctorValidator implements Validator {
    /*
     I am creating a composite pattern where I am maintaining a Set of validating strategies
     */
    Set<ValidationStrategy> strategies ;

    public DoctorValidator(Set<ValidationStrategy> strategies) {
        this.strategies = strategies;
    }


    public Map<DoctorValidationType,List<Error>> validate(Doctor doctor) {
        ValidationStrategy userValidation = null;
        Map<DoctorValidationType,List<Error>> validated = new LinkedHashMap<>();
        for (Iterator<ValidationStrategy> iterator = strategies.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            List<Error> errors = userValidation.validate(doctor);
            if(errors.size() > 0){
                validated.put(userValidation.getValidationType(),errors);
            }
        }
        return validated;
    }
}
