package validator.functional;

import validator.strategy.Error;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try{
            check("");
        }catch (ValidationException ex){
            System.out.println(ex.getRoot());
        }
    }
    private static void check(String id){

        Validator<String> idValidator = new Validator<String>("Id",new LinkedHashSet<>() {{
            add(IdValidationStrategy.EMPTY);
            add(IdValidationStrategy.NULL);
            add(IdValidationStrategy.FORMAT);
        }});
        List<Error> idValidationErrors = idValidator.validate(id);
        if(idValidationErrors.size() > 0){
            System.out.println(idValidator.getIdentifier());
            throw new ValidationException(idValidationErrors);
        }
    }
}
