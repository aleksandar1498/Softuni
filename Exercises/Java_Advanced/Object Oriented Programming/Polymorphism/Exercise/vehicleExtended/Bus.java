package vehicle;

public class Bus extends Vehicle {
    private final static double AIR_CONDITIONER_INCREASE=1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double km) {
        double neededFuel=(this.getFuelConsumption()+AIR_CONDITIONER_INCREASE)*km;
        if(this.getFuelQuantity() >= neededFuel){
            System.out.println("Bus travelled "+super.decimalFormat.format(km)+" km");
            this.setFuelQuantity(this.getFuelQuantity()-neededFuel);
        }else{
            System.out.println("Bus needs refueling");
        }
    }

    public void driveEmpty(double km) {
        double neededFuel=this.getFuelConsumption()*km;
        if(this.getFuelQuantity() >= neededFuel){
            System.out.println("Bus travelled "+super.decimalFormat.format(km)+" km");
            this.setFuelQuantity(this.getFuelQuantity()-neededFuel);
        }else{
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    public void refuel(double litres) {
        if(litres <= 0){
            System.out.println("Fuel must be a positive number");
            return;
        }
        if(this.getFuelQuantity()+litres > this.getTankCapacity()){
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.setFuelQuantity(this.getFuelQuantity()+litres);
    }
}
