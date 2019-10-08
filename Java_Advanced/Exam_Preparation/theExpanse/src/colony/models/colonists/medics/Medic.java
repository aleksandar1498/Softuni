package colony.models.colonists.medics;

import colony.interfaces.MedicInterface;
import colony.models.colonists.Colonist;

public abstract class Medic extends Colonist implements MedicInterface {
    private static final int FLAT_BONUS = 2;
    private String sign;
    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id,familyId,talent,age);
        this.sign = sign;
    }

    @Override
    public String getSign() {
        return this.sign;
    }

    @Override
    public int getPotential() {
        return this.getTalent()+FLAT_BONUS;
    }
}
