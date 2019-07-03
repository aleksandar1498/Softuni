package restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {
    protected  double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.setMilliliters(milliliters);
    }

    protected double getMilliliters() {
        return this.milliliters;
    }

    protected void setMilliliters(double milliliters) {

        if(milliliters <= 0){
            throw new IllegalArgumentException("Invalid argument!");
        }
            this.milliliters = milliliters;
    }
}
