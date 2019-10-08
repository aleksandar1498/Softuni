package colony.models.colonists.medics;

public class Surgeon extends Medic {
    private static final int AGE_BONUS = 2;
    private static final int SIGN_BONUS = 3;
    private static final int SIGN_PENALITY = -3;
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int totPotential = super.getPotential();
        if(this.getAge() > 25 && this.getAge() < 35){
            totPotential+=AGE_BONUS;
        }
        if(this.getSign().equals("precise")){
            totPotential+=SIGN_BONUS;
        }else if(this.getSign().equals("butcher")){
            totPotential+=SIGN_PENALITY;
        }
        return totPotential;
    }
}
