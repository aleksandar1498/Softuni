package models.boats;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.races.Race;

public class RowBoat extends BoatImpl{
    private int oars;
    public RowBoat(String model, Integer weight, Integer oars) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private int getOars() {
        return oars;
    }

    private void setOars(int oars) throws ParameterArgumentException {
        if(oars < 0){
            throw new ParameterArgumentException("Oars");
        }
        this.oars = oars;
    }

    @Override
    public double getSpeed(Race race) {
        int oars = this.getOars();
        int oceanSpeed = race.getOceanSpeed();
        double speed = (oars*100) - super.getWeight() + oceanSpeed;
        return (speed <= 0)?Double.MAX_VALUE:speed;
    }
}
