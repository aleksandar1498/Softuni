package models.boats;

import annotations.Motorboat;
import annotations.MultiMotorboat;
import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.engines.BoatEngine;
import interfaces.races.Race;

@MultiMotorboat
public class PowerBoat extends BoatImpl {
    private BoatEngine firstBoatEngine;
    private BoatEngine secondBoatEngine;

    public PowerBoat(String model, Integer weight, BoatEngine firstBoatEngine, BoatEngine secondBoatEngine) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.firstBoatEngine = firstBoatEngine;
        this.secondBoatEngine = secondBoatEngine;
    }

    private BoatEngine getFirstBoatEngine() {
        return firstBoatEngine;
    }

    private BoatEngine getSecondBoatEngine() {
        return secondBoatEngine;
    }

    @Override
    public double getSpeed(Race race) {
        int oceanSpeed = race.getOceanSpeed();
        double speed = (this.getFirstBoatEngine().getOutput() + this.getSecondBoatEngine().getOutput()) - super.getWeight() + (oceanSpeed / 5.00);
        return (speed <= 0)?Double.MAX_VALUE:speed;
    }
}
