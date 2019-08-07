package vehicle;

public class Car extends Vehicle {
    private final static double AIR_CONDITIONER_INCREASE=.9;
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+AIR_CONDITIONER_INCREASE);
    }

    @Override
    public void drive(double km) {
        double neededFuel=this.getFuelConsumption()*km;
        if(this.getFuelQuantity() >= neededFuel){
            System.out.println("Car travelled "+super.decimalFormat.format(km)+" km");
            this.setFuelQuantity(this.getFuelQuantity()-neededFuel);
        }else{
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double litres) {
        super.setFuelQuantity(this.getFuelQuantity()+litres);
    }

}
