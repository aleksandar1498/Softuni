package cresla.entities.modules;

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

    @Override
    public String toString() {
        return String.format("%s%nEnergy Output %d"
                ,super.toString(), this.getEnergyOutput());
    }
}
