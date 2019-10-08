package colony.models.colonists.engineers;

import colony.models.colonists.Colonist;

public abstract class Engineer extends Colonist {
    private static final int CLASS_BONUS = 3;
    private static final int AGE_BONUS = 2;
    protected Engineer(String id,String familyId,int talent,int age) {
        super(id,familyId,talent,age);
    }

    @Override
    public int getPotential() {
        int totPotential = this.getTalent()+CLASS_BONUS;
        if(this.getAge() > 30){
            totPotential+=AGE_BONUS;
        }
        return totPotential;
    }
}
