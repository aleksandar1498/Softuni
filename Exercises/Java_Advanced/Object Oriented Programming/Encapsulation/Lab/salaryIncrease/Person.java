package salaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;



    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
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

    @Override
    public String toString() {
        DecimalFormat decimalFormat=new DecimalFormat("#######.0###");
        return String.format("%s %s gets %s leva.", this.getFirstName(), this.getLastName(), decimalFormat.format(this.getSalary()));
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {

            this.setSalary( (this.getSalary() * (1.0 + bonus / 100*.5)));
        } else {
            this.setSalary((this.getSalary() * (1.0 + bonus / 100)));

        }
    }
}
