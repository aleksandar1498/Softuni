package vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    protected DecimalFormat decimalFormat;
    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.decimalFormat=new DecimalFormat("#########.##");
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public abstract void drive(double km);
    public abstract void refuel(double km);

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.getFuelQuantity());
    }
}
