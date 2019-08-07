package pizzaCalories;

public enum BakingTechnique {
    Crispy(.9),
    Chewy (1.1),
    Homemade (1.0);
    private double calories;

    BakingTechnique(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
