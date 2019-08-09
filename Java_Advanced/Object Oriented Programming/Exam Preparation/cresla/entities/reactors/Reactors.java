package cresla.entities.reactors;

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
       return this.getModuleContainer().getTotalEnergyOutput();
    }
    @Override
    public long getTotalHeatAbsorbing() {
        return this.getModuleContainer().getTotalHeatAbsorbing();
    }


    Container getModuleContainer() {
        return this.moduleContainer;
    }



    @Override
    public String toString() {
        return String.format("%s – %d\n" +
                        "Energy Output: %d\n" +
                        "Heat Absorbing: %d\n" +
                        "Modules: %d"
                , this.getClass().getSimpleName()
                , this.getId()
                ,(this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing())?0:this.getTotalEnergyOutput()
                , this.getTotalHeatAbsorbing()
                , this.getModuleCount()
        );
    }
    @Override
    public int getId() {
        return this.id;
    }
}
