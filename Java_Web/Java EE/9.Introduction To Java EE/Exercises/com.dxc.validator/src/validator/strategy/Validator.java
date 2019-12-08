package validator.strategy;

import models.Doctor;

import java.util.List;
import java.util.Map;

public interface Validator {
    Map<DoctorValidationType,List<Error>> validate(Doctor doctor);
}
