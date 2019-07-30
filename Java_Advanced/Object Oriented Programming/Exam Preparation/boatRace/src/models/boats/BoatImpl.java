package models.boats;

import interfaces.boats.Boat;

public abstract class BoatImpl implements Boat {
    private String model;
    private int weight;

    public BoatImpl(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
