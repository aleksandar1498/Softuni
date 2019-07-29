package models.boats;

public class SailBoat extends BoatImpl {
    private int efficiency;
    public SailBoat(String model, int weight, int efficiency) {
        super(model, weight);
        this.efficiency = efficiency;
    }
}
