package models.boats;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.races.Race;

public class SailBoat extends BoatImpl {
    private int efficiency;
    public SailBoat(String model, Integer weight, Integer efficiency) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.efficiency = efficiency;
    }

    private int getEfficiency() {
        return efficiency;
    }

    private void setEfficiency(int efficiency) {
        if(efficiency < 0 || efficiency > 100){
            throw new IllegalArgumentException("Sail Effectiveness must be between [1...100]");
        }
        this.efficiency = efficiency;
    }
    @Override
    public double getSpeed(Race race) {
       int windSpeed = race.getWindSpeed();
        int oceanSpeed = race.getOceanSpeed();
        double speed =windSpeed * (this.getEfficiency() / 100.0) - super.getWeight() + (oceanSpeed / 2.0);
        //(Race Wind Speed * (Boat Sail Efficiency / 100)) – Boat’s Weight + (Race Ocean Current Speed / 2) ;
        return (speed <= 0)?Double.MAX_VALUE:speed;
    }
}
