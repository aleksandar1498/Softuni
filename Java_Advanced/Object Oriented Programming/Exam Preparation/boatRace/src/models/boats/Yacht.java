package models.boats;

import annotations.Motorboat;
import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.engines.BoatEngine;
import interfaces.races.Race;

@Motorboat
public class Yacht extends BoatImpl{
    private BoatEngine boatEngine;
    private int cargo;
    public Yacht(String model, int weight, BoatEngine boatEngine, int cargo) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.setCargo(cargo);
    }

    public void setCargo(int cargo) throws ParameterArgumentException {
        if(cargo < 0){
            throw new ParameterArgumentException("Cargo Weight");
        }
        this.cargo = cargo;
    }

    private BoatEngine getBoatEngine() {
        return boatEngine;
    }

    private int getCargo() {
        return cargo;
    }

    @Override
    public double getSpeed(Race race) {
        int oceanSpeed = race.getOceanSpeed();
        double speed = this.getBoatEngine().getOutput() - (super.getWeight() + this.getCargo()) + (oceanSpeed / 2.0);
        return (speed <= 0)?Double.MAX_VALUE:speed;
    }
}
