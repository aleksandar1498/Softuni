package cresla.entities;

import cresla.interfaces.Container;

public class CryoReactor extends Reactors {
    private int cryoProductionIndex;

    public CryoReactor(int id, int size, int cryoProductionIndex) {
        super(id, size);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long totEnergyOutput = super.getModuleContainer().getTotalEnergyOutput()*this.cryoProductionIndex;
        if(totEnergyOutput> this.getTotalHeatAbsorbing()){
            return 0;
        }
        return totEnergyOutput;
    }
}
