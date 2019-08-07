package models.boats;

public class RowBoat extends BoatImpl{
    private int oars;
    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.oars = oars;
    }


}
