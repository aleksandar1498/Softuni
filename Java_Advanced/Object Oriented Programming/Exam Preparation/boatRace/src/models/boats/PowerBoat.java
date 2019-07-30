package models.boats;

import annotations.Motorboat;
import annotations.MultiMotorboat;
import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.engines.BoatEngine;

@MultiMotorboat
public class PowerBoat extends BoatImpl {
    private BoatEngine firstBoatEngine;
    private BoatEngine secondBoatEngine;

    public PowerBoat(String model, Integer weight, BoatEngine firstBoatEngine, BoatEngine secondBoatEngine) throws ParameterArgumentException, ModelArgumentException {
        super(model, weight);
        this.firstBoatEngine = firstBoatEngine;
        this.secondBoatEngine = secondBoatEngine;
    }
}
