package validator.validator;



import validator.functional.Error;
import validator.functional.ValidationException;
import validator.validator.interfaces.Validator;
import validator.validator.interfaces.ValidatorContainer;
import validator.validator.models.rules.simple.StringConstraintRule;
import validator.validator.models.rules.simple.StringEmptinessRule;
import validator.validator.models.rules.simple.StringFormatRule;
import validator.validator.models.validators.IdValidator;
import validator.validator.models.validators.ValidatorContainerImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ValidatorContainer container = new ValidatorContainerImpl();
        final Validator idValidator = new IdValidator("ID",new LinkedHashSet<>(){{
            add(new StringEmptinessRule());
            add(new StringConstraintRule(4,8));
            add(new StringFormatRule("(PAT|DOC)[0-9]{3}"));
        }});
        final Validator idValidator2 = new IdValidator("ID2",new LinkedHashSet<>(){{
            add(new StringFormatRule("(PATC|DOC)[0-9]{3}"));
        }});

        container.addValidator(idValidator.getIdentifier(),idValidator.validate("PAT11111"));
        container.addValidator(idValidator2.getIdentifier(),idValidator2.validate("DOC111"));

        Map<String,List<Error>> errors = container.execute();

        for(var err : errors.entrySet()){
            System.out.println(err.getKey());
            for (var reason : err.getValue()){
                System.out.println("-- "+reason.getErrorKey());
            }
        }
       /* List<Error> idValidationErrors = validator.apply(idValidator,"PA11");
        if(idValidationErrors.size() > 0){
            try {
                throw new ValidationException(idValidationErrors);
            }catch (ValidationException e){
                for(Error error : e.getRoot()){
                    System.out.println(error.getErrorKey());
                }
            }
        }*/



    }
}
