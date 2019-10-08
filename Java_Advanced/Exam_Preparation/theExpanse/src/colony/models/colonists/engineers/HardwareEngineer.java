package colony.models.colonists.engineers;

public class HardwareEngineer extends Engineer {
    private static final int AGE_BONUS = 2;
    public HardwareEngineer(String id,String familyId,int talent,int age) {
        super(id,familyId,talent,age);
    }

    @Override
    public int getPotential() {
        int totPotential = super.getPotential();
        if(this.getAge() < 18){
            totPotential+=AGE_BONUS;
        }
        return totPotential;
    }
}
