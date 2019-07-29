package vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private  double tankCapacity;
    protected DecimalFormat decimalFormat;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.decimalFormat=new DecimalFormat("#########.##");
    }

    public double getTankCapacity() {
        return tankCapacity;
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

    public abstract void drive(double km);
    public abstract void refuel(double litres);

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.getFuelQuantity());
    }
}
