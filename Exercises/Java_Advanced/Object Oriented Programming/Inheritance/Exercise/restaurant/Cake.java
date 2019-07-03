package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private static double CAKE_GRAMS = 250;
    private static double CAKE_CALORIES = 1000;
    private static BigDecimal CAKE_PRICE = new BigDecimal(5);
    public Cake(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams, calories);
        super.setPrice(CAKE_PRICE);
        super.setCalories(CAKE_CALORIES);
        super.setGrams(CAKE_GRAMS);
    }
}
