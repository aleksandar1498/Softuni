package rpg_lab;

import interfaces.Target;
import interfaces.Weapon;

public class AxeImpl implements Weapon {

    private int attackPoints;
    private int durabilityPoints;

    public AxeImpl(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }

        public int getAttackPoints() {
        return this.attackPoints;
    }

        public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    public void attack(Target target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("rpg_lab.AxeImpl is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }
}
