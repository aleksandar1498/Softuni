package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }


    public double calculateCalories() {
        return 2 * this.weight * ToppingType.valueOf(this.getToppingType()).getCalories();
    }

    private String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        try {
            ToppingType.valueOf(toppingType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
}
