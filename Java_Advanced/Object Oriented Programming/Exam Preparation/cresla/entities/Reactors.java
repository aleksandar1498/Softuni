package cresla.entities;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;

import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class Reactors implements Reactor {
    private int id;
    private Container moduleContainer;

    Reactors(int id,int size) {
        this.id = id;
        this.moduleContainer = new ModuleContainer(size);
    }

    @Override
    public int getModuleCount() {
        return this.moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public long getTotalEnergyOutput() {

        return this.moduleContainer.getTotalEnergyOutput();
    }

    Container getModuleContainer() {
        return this.moduleContainer;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }


    @Override
    public int getId() {
        return this.id;
    }
}
