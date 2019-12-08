package validator.functional;

public enum NumericValidationStrategy implements SimpleValidationStrategy<Integer> {
    ZERO("Cannot be equal to zero"){
        @Override
        public boolean validate(Integer data) {
            return data != 0;
        }
    },
    LESS_THAN_5("Cannot be less then five"){
        @Override
        public boolean validate(Integer data) {
            return data > 5;
        }
    };


    private String message;
    NumericValidationStrategy(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
