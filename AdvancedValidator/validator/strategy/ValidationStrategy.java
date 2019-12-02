package validator.strategy;

import models.Doctor;

import java.util.List;

public interface ValidationStrategy {
    List<Error> validate(Doctor doctor);
    DoctorValidationType getValidationType();
}
