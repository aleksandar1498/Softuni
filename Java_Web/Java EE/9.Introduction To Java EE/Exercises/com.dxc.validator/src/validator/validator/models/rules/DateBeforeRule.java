package validator.validator.models.rules;

import java.util.Date;

import validator.validator.errors.ErrorType;

public class DateBeforeRule extends ConstraintsRule<Date> {
    private Date dateToCompare;

    public DateBeforeRule(final Date currentDate) {
        this.dateToCompare = currentDate;
    }

    @Override
    public boolean validate(final Date date, final Object... params) {
        System.out.println(date + " " + this.dateToCompare);
        return date.before(dateToCompare);
    }

    @Override
    public ErrorType getError() {
        return ErrorType.BEFORE;
    }

    @Override
    public Object[] getParams() {
        return new Object[] { dateToCompare };
    }

}
