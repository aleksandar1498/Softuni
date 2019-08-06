package fakes;

import interfaces.Target;
import interfaces.Weapon;
import utils.Constants;

import java.util.List;
import java.util.Random;

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

    @Override
    public List<Weapon> getWeapons() {
        return null;
    }

    @Override
    public Weapon releaseLoot() {
        return null;
    }

}
