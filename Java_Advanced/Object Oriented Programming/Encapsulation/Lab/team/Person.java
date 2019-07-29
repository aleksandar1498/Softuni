package team;

import java.text.DecimalFormat;

public class Person {
    private static final int MIN_NAME_LENGTH=3;
    private  static final double MIN_SALARY=460.0;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if(salary < MIN_SALARY){
            throw new IllegalArgumentException("Salary cannot be less then 460 leva");
        }

        this.salary = salary;
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

    public void setFirstName(String firstName) {
        if(firstName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException("First name cannot be less then 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException("Last name cannot be less then 3 symbols");
        }
        this.lastName = lastName;

    }

    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#######.0###");
        return String.format("%s %s gets %s leva.", this.getFirstName(), this.getLastName(), decimalFormat.format(this.getSalary()));
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {

            this.setSalary((this.getSalary() * (1.0 + bonus / 100 * .5)));
        } else {
            this.setSalary((this.getSalary() * (1.0 + bonus / 100)));

        }
    }
}
