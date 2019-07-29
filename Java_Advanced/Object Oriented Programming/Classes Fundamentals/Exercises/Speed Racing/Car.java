package oop.speedracing;

import java.text.DecimalFormat;

public class Car implements Comparable<Car> {
    private String model;
    DecimalFormat df=new DecimalFormat("############.##");
    private double fuelAmount;
    private double fuelCostPerKM;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKM = fuelCostPerKM;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostPerKM() {
        return fuelCostPerKM;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostPerKM(double fuelCostPerKM) {
        this.fuelCostPerKM = fuelCostPerKM;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean isEnoughFuel(double needFuel) {
        return needFuel <= fuelAmount;
    }

    public void move(double km) {
        double neededFuel = km * this.getFuelCostPerKM();
        if (isEnoughFuel(neededFuel)) {
            this.setFuelAmount(this.getFuelAmount() - neededFuel);
            this.setDistanceTraveled(this.getDistanceTraveled() + km);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public int compareTo(Car c) {
        return this.getModel().compareTo(c.getModel());
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s",model , fuelAmount , df.format( distanceTraveled));
    }
}
