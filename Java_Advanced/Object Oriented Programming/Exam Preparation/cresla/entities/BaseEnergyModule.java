package cresla.entities;

import cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends Modules implements EnergyModule {
    private int energyOutput;

     BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
