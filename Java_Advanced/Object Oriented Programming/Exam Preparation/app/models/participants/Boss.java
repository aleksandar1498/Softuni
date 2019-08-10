package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends BaseTargetable {

    public Boss() {
        super.setGold(Config.BOSS_GOLD);
        this.setHealth(Config.BOSS_HEALTH);

    }

    public void receiveReward(double reward) {
        super.setGold(super.getGold()+reward * .1);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }


}
