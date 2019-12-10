package validator.validator;



import validator.validator.errors.Error;
import validator.validator.exceptions.ValidationException;
import validator.validator.interfaces.Validator;
import validator.validator.interfaces.ValidatorContainer;
import validator.validator.models.validators.DoctorIdValidator;
import validator.validator.models.validators.PatientIdValidator;
import validator.validator.models.validators.ValidatorContainerImpl;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ValidatorContainer validatorContainer = new ValidatorContainerImpl();
        final Validator patientIdValidator = new PatientIdValidator();
        final Validator doctorIdValidator = new DoctorIdValidator();
        validatorContainer.addValidator(patientIdValidator.getIdentifier(),patientIdValidator.validate("PAT111"));
        validatorContainer.addValidator(doctorIdValidator.getIdentifier(),doctorIdValidator.validate("PAT111"));

        try{
            validatorContainer.checkValidated();
        }catch (ValidationException e){

            for(var err : e.getRoot().entrySet()){
                System.out.println(err.getKey());
                for (var reason : err.getValue()){
                    System.out.printf(" %s%n",reason);
                }
            }
        }






    }
}
