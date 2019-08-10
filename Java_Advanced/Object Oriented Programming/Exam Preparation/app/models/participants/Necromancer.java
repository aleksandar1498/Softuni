package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Necromancer extends BaseHero {

    public Necromancer() {
        this.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        this.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        this.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + (this.getDexterity()*2) + (this.getIntelligence()*2);
    }


}
