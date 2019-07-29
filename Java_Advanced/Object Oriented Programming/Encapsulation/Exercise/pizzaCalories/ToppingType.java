package pizzaCalories;

public enum ToppingType {
    Meat(1.2),
    Veggies(.8),
    Cheese(1.1),
    Sauce(.9);
    private double calories;

    ToppingType(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
