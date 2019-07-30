package rpg_lab;

import interfaces.Target;
import interfaces.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> weapons;
    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.weapons = new ArrayList<>();
    }

    public int getHealth() {
        return this.health;
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("rpg_lab.Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }
    public Weapon releaseLoot(){
        System.out.println("Called");
        if(this.isDead()){
            Random random = new Random();
            int index = random.nextInt(this.getWeapons().size());
            return this.weapons.remove(index);
           // return new AxeImpl(10,10);
        }
        return null;
    }
    public boolean isDead() {
        return this.health <= 0;
    }
}
