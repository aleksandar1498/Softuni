package models.boats;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;

public class RowBoat extends BoatImpl{
    private int oars;
    public RowBoat(String model, Integer weight, Integer oars) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) throws ParameterArgumentException {
        if(oars < 0){
            throw new ParameterArgumentException("Oars");
        }
        this.oars = oars;
    }
}
