package exceptionHandling;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException("Last name cannot be null");

        }
        if(lastName.isEmpty() || lastName.matches("\\s+")){
            throw new IllegalArgumentException("Last name cannot be neither empty ");
        }
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException("First name cannot be null");

        }
        if(firstName.isEmpty() || firstName.matches("\\s+")){
            throw new IllegalArgumentException("First name cannot be neither empty or null");
        }
        this.firstName = firstName;
    }

    public void setAge(int age) {
        if(age < 0 || age > 20){
            throw new IllegalArgumentException("Age must be in range 0 ... 120");
        }
        this.age = age;
    }


}
