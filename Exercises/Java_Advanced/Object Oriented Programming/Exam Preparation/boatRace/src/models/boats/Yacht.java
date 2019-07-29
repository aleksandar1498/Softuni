package models.boats;

import annotations.Motorboat;
import interfaces.engines.BoatEngine;

@Motorboat
public class Yacht extends BoatImpl{
    private BoatEngine boatEngine;
    private int cargo;
    public Yacht(String model, int weight, BoatEngine boatEngine, int cargo) {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.cargo = cargo;
    }
}
