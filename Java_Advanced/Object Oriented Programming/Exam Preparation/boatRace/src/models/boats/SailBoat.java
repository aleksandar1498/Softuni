package models.boats;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;

public class SailBoat extends BoatImpl {
    private int efficiency;
    public SailBoat(String model, Integer weight, Integer efficiency) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.efficiency = efficiency;
    }

    private void setEfficiency(int efficiency) {
        if(efficiency < 0 || efficiency > 100){
            throw new IllegalArgumentException("Sail Effectiveness must be between [1...100]");
        }
        this.efficiency = efficiency;
    }
}
