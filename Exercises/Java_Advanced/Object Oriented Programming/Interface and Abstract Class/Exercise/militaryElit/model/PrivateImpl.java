package militaryElit.model;

import militaryElit.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private int id;
    private String firstName;
    private String lastName;
    private double salary;



    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f",super.toString(),this.getSalary());
    }
}
