package mankind;

public class Human {
    protected String firstName;
    protected String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if(!Character.isUpperCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if(!Character.isUpperCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if(firstName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append("First Name: ").append(firstName);
        builder.append(System.lineSeparator());
        builder.append("Last Name: ").append(lastName);
        return builder.toString();
    }
}
