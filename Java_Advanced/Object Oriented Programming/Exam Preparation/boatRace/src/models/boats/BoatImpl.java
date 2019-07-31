package models.boats;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;
import interfaces.boats.Boat;

import java.lang.reflect.Parameter;

public abstract class BoatImpl implements Boat {
    private String model;
    private int weight;

    public BoatImpl(String model, int weight) throws ModelArgumentException, ParameterArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setModel(String model) throws ModelArgumentException {
        if(model.length() < 5){
            throw new ModelArgumentException("5");
        }
        this.model = model;
    }
    private void setWeight(int weight) throws ParameterArgumentException {
        if(weight < 0){
            throw  new ParameterArgumentException("Weight");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getModel() {
        return this.model;
    }


}
