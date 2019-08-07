package interfaces;

import rpg_lab.Dummy;

public interface Weapon {
    void attack(Target target);

    int getAttackPoints();

    int getDurabilityPoints();
}
