package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Wizard extends BaseHero {


    public Wizard() {
        this.setStrength(Config.WIZARD_BASE_STRENGTH);
        this.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        this.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
    }



    public double getDamage() {
        return (this.getIntelligence() * 2) + this.getDexterity();
    }


}
