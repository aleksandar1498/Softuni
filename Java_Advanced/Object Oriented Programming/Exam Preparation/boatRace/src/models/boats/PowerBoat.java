package models.boats;

import annotations.Motorboat;
import interfaces.engines.BoatEngine;

@Motorboat
public class PowerBoat extends BoatImpl {
    private BoatEngine firstBoatEngine;
    private BoatEngine secondBoatEngine;

    public PowerBoat(String model, int weight, BoatEngine firstBoatEngine, BoatEngine secondBoatEngine) {
        super(model, weight);
        this.firstBoatEngine = firstBoatEngine;
        this.secondBoatEngine = secondBoatEngine;
    }
}
