package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int totToppings;



    public Pizza(String name, int totToppings) {
        this.setName(name);
        this.setToppings(totToppings);
    }

    public void setName(String name) {
        if (name.length() < 1 || name.length() > 15 || name.matches("\\s+")) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setTotToppings(int totToppings) {
        if (totToppings < 0 || totToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.totToppings = totToppings;

    }

    private void setToppings(int totToppings) {
        this.setTotToppings(totToppings);
        this.toppings = new ArrayList<>(totToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    private double getOverallCalories() {
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getOverallCalories());
    }

}
