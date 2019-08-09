package cresla.entities.reactors;

public class CryoReactor extends Reactors {
    private int cryoProductionIndex;

    public CryoReactor(int id, int size, int cryoProductionIndex) {
        super(id, size);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return  super.getTotalEnergyOutput() * this.cryoProductionIndex;
    }



}
