package cresla.entities.modules;

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
    @Override
    public String toString() {
        return String.format("%s%nHeat Absorbing %d"
                ,super.toString(), this.getHeatAbsorbing());
    }

}
