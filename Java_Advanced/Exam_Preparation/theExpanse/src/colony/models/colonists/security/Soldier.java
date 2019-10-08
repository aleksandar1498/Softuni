package colony.models.colonists.security;

import colony.models.colonists.Colonist;

public class Soldier extends Colonist {
    private static final int CLASS_BONUS = 3;
    private static final int AGE_BONUS = 3;
    public Soldier(String id,String familyId,int talent,int age) {
        super(id,familyId,talent,age);
    }

    @Override
    public int getPotential() {
        return this.getTalent()+CLASS_BONUS+AGE_BONUS;
    }
}
