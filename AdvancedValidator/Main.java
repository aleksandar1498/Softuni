import models.Doctor;
import validator.*;
import validator.Error;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Set<ValidationStrategy> strategies = new LinkedHashSet<>();
        strategies.add(DoctorValidationStrategy.ID);
        strategies.add(DoctorValidationStrategy.AGE);
        strategies.add(DoctorValidationStrategy.FIRST_NAME);
        Doctor doctor = new Doctor("","",112);
        DoctorValidator validator = new DoctorValidator(strategies);
        Map<DoctorValidationType, List<Error>> errors = validator.validate(doctor);
        if(errors.size() > 0){
            try {
                throw new ValidationException(errors);
            }catch (ValidationException e){
                System.out.println(e.getRoot());
            }
        }
    }
}
