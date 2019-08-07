package arena;

import java.lang.reflect.Field;

public class Gladiator {
    String name;
    Stat stat;
    Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }
    public int getStatPower(){
        int totPower=0;
        totPower+=this.stat.getAgility();
        totPower+=this.stat.getFlexibility();
        totPower+=this.stat.getIntelligence();
        totPower+=this.stat.getSkills();
        totPower+=this.stat.getStrength();
        return totPower;
    }
    public int getWeaponPower(){
        int weaponPower=0;
        weaponPower+=this.weapon.getSharpness();
        weaponPower+=this.weapon.getSize();
        weaponPower+=this.weapon.getSolidity();
        return weaponPower;
    }
    public int getTotalPower(){
        return this.getWeaponPower()+this.getStatPower();
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %d%n Weapon Power: %d%n Stat Power: %d",
                this.getName(),this.getTotalPower(),this.getWeaponPower(),this.getStatPower()
                );
    }
}
