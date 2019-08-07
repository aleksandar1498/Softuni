package models.engines;

import interfaces.engines.BoatEngine;

public abstract class BoatEngineImpl implements BoatEngine {
    private String model;
    private int output;
    private int horsePower;
    private int displacement;

    public BoatEngineImpl(String model, int horsePower, int displacement) {
        this.model = model;
        this.horsePower = horsePower;
        this.displacement = displacement;
    }

    @Override
    public String getModel() {
        return model;
    }

    protected void setOutput(int output){
        this.output = output;
    }
}
