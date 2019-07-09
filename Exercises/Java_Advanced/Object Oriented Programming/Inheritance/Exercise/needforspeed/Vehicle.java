package needforspeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION =1.25;
    private double fuelConsumption ;
    private double fuel;
    private int horsePower;


    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }
    public void drive(double kilometers){
        double neededFuel=this.fuelConsumption*kilometers;
        if(neededFuel <= this.getFuel()){
            this.fuel-=neededFuel;
        }
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public static double getDefaultFuelConsumption() {
        return Vehicle.DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }


    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}