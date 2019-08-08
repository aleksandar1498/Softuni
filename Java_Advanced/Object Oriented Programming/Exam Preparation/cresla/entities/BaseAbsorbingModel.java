package cresla.entities;

import cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorbingModel extends Modules implements AbsorbingModule  {
    private int heatAbsorbing;

    BaseAbsorbingModel(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }


}
