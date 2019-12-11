package validator.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import validator.validator.exceptions.ValidationException;
import validator.validator.models.rules.DateBeforeRule;
import validator.validator.models.rules.StringConstraintRule;
import validator.validator.models.rules.StringFormatRule;
import validator.validator.models.validators.BaseValidator;

public class Main {
    public static void main(final String[] args) throws ParseException {
        /*
         * final ValidatorContainer validatorContainer = new ValidatorContainerImpl();
         * // PatientIdValidator.validate("PAT111") final PatientIdValidator validator =
         * new PatientIdValidator(); validatorContainer.addValidator("ID",
         * validator.validate("PAT111111")); try { validatorContainer.checkValidated();
         * } catch (final ValidationException e) { for (final var err :
         * e.getRoot().entrySet()) { System.out.println(err.getKey()); for (final var
         * reason : err.getValue()) { System.out.printf(" %s%n", reason); } } }
         */
        final String myDate = "2024/10/29 18:10:45";
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        final Date date = sdf.parse(myDate);
        final long millis = date.getTime();

        final BaseValidator validator = new BaseValidator();
        validator.validate("PAT_ID", "PAT1112", new StringFormatRule("PAT[0-9]{3}"));
        validator.validate("PAT_ID", "PAT11asd12", new StringConstraintRule(5, 10));
        validator.validate("DOC_ID", "PAT11asd12", new StringConstraintRule(5, 10));
        validator.validate("TEST_DUE_DATE", new Date(millis), new DateBeforeRule(new Date()));
        try {
            validator.checkValidated();
        } catch (final ValidationException e) {

            for (final var err : e.getRoot().entrySet()) {
                System.out.println(err.getKey());
                for (final var reason : err.getValue()) {
                    System.out.printf(" %s%n", reason);
                }
            }
        }

    }

}
