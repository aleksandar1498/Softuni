package farm;

import java.text.DecimalFormat;

public class Chicken {
    private DecimalFormat decimalFormat;
    private String name;
    private int age;

    public Chicken(String name, int age) {
        decimalFormat=new DecimalFormat("#.##");
        this.setName(name);
        this.setAge(age);
    }



    private void setName(String name) {
        if (name.equals(" ") || name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (this.age <= 5) {
            return 2;
        } else if (this.age <= 12) {
            return 1;
        }
        return .75;

    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.%n",this.name,this.age,decimalFormat.format(this.productPerDay()));
    }
}
