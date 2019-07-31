package models.engines;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.engines.BoatEngine;

public abstract class BoatEngineImpl implements BoatEngine {
    private String model;
    private int output;
    private int horsePower;
    private int displacement;

    public BoatEngineImpl(String model, int horsePower, int displacement) throws ModelArgumentException, ParameterArgumentException {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setDisplacement(displacement);
    }

    @Override
    public int getOutput() {
        return this.output;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public int getDisplacement() {
        return this.displacement;
    }

    protected void setOutput(int output) {
        this.output = output;
    }


    private void setModel(String model) throws ModelArgumentException {
        if (model.length() < 3) {
            throw new ModelArgumentException("3");
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) throws ParameterArgumentException {
        if (horsePower < 0) {
            throw new ParameterArgumentException("Horsepower");
        }
        this.horsePower = horsePower;
    }

    private void setDisplacement(int displacement) throws ParameterArgumentException {
        if (displacement < 0) {
            throw new ParameterArgumentException("Displacement");
        }
        this.displacement = displacement;
    }

}
