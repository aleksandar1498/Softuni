package fakes;

import interfaces.Target;
import interfaces.Weapon;
import rpg_lab.Dummy;

public class StubWeapon implements Weapon {
    @Override
    public void attack(Target target) {

    }

    @Override
    public int getAttackPoints() {
        return 10;
    }

    @Override
    public int getDurabilityPoints() {
        return 0;
    }
}
