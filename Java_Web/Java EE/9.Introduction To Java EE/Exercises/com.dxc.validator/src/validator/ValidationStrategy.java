package validator;

import models.Doctor;
import validator.DoctorValidationType;

import java.util.List;

public interface ValidationStrategy {
    List<Error> validate(Doctor doctor);
    DoctorValidationType getValidationType();
}
