package cresla.entities.reactors;

public class HeatReactor extends Reactors {
    private int heatReductionIndex;

    public HeatReactor(int id, int size, int heatReductionIndex) {
        super(id, size);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReductionIndex;
    }


}
