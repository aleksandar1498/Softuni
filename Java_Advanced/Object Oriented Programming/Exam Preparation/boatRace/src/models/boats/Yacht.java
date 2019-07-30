package models.boats;

import annotations.Motorboat;
import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.engines.BoatEngine;

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
}
