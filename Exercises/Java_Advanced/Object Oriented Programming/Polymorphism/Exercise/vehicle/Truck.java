package vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    private final static double AIR_CONDITIONER_INCREASE=1.6;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+AIR_CONDITIONER_INCREASE);
    }

    @Override
    public void drive(double km) {
        double neededFuel=this.getFuelConsumption()*km;
        if(this.getFuelQuantity() >= neededFuel){
            System.out.println("Truck travelled "+super.decimalFormat.format(km)+" km");
            this.setFuelQuantity(this.getFuelQuantity()-neededFuel);
        }else{
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double litres) {
        super.setFuelQuantity(this.getFuelQuantity()+(litres*.95));

    }
}
