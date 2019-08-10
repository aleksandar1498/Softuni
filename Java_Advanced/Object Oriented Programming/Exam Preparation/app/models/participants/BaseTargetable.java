package app.models.participants;

import app.contracts.Targetable;
public abstract class BaseTargetable implements Targetable {
    private double health;
    private String name;
    private boolean isAlive;
    private double gold;
    BaseTargetable() {
        this.isAlive = true;

    }

    void setGold(double gold) {
        this.gold = gold;
    }


    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }




    public void takeDamage(double damage) {
        if(this.getHealth()-damage <= 0){
            this.isAlive = false;
            this.setHealth(0);
        }else{
            this.setHealth(this.getHealth()-damage);
        }

    }
    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        if(!this.isAlive){
            targetable.receiveReward(this.getGold());
            this.gold = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getGold() {
        return this.gold;
    }

    public boolean isAlive() {
        return this.isAlive;
    }
}
