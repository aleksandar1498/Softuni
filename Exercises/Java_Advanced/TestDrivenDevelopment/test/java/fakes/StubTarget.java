package fakes;

import interfaces.Target;
import utils.Constants;

public class StubTarget implements Target {
    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void takeAttack(int attackPoints) {

    }

    @Override
    public int giveExperience() {
        return Constants.DUMMY_XP;
    }

    @Override
    public boolean isDead() {
        return true;
    }
}
