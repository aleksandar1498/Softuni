package colony.models.colonists.medics;

public class GeneralPractitioner extends Medic {
    private static final int AGE_BONUS = 1;
    private static final int SIGN_BONUS = 1;
    private static final int SIGN_PENALITY = -2;
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int totPotential = super.getPotential();
        if(this.getAge() > 15){
            totPotential+=AGE_BONUS;
        }
        if(this.getSign().equals("caring")){
            totPotential+=SIGN_BONUS;
        }else if(this.getSign().equals("careless")){
            totPotential+=SIGN_PENALITY;
        }
        return totPotential;
    }
}
