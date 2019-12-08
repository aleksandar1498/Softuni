package validator.strategy;

import models.Doctor;

import java.util.ArrayList;
import java.util.List;

public enum DoctorValidationStrategy implements ValidationStrategy{
    ID(DoctorValidationType.ID){
        @Override
        public List<Error> validate(Doctor input) {
            List<Error> errors = new ArrayList<>();

            if(input.getId() == null) {
                errors.add(new Error("cannot be null"));
                return errors;
            }
            if(input.getId().isEmpty()){
                errors.add(new Error("cannot be empty"));
            }
            return errors;
        }
    },
    FIRST_NAME(DoctorValidationType.FIRST_NAME){
        @Override
        public List<Error> validate(Doctor input) {
            List<Error> errors = new ArrayList<>();

            if(input.getFirstName() == null) {
                errors.add(new Error("cannot be null"));
                return errors;
            }
            if(input.getFirstName().isEmpty()){
                errors.add(new Error("cannot be empty"));
            }
            return errors;
        }
    },
    AGE(DoctorValidationType.AGE){
        @Override
        public List<Error> validate(Doctor input) {
            List<Error> errors = new ArrayList<>();

            if(input.getAge() <= 0 ) {
                errors.add(new Error("cannot be less or equal 0"));
            }
            if(input.getAge() > 100 ){
                errors.add(new Error("cannot be more than 100"));
            }
            return errors;
        }
    };

    private DoctorValidationType validationType;
    DoctorValidationStrategy(DoctorValidationType validationType) {
        this.validationType = validationType;
    }
    public DoctorValidationType getValidationType() {
        return validationType;
    }
}
