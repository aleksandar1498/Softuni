package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private boolean canBreath;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if(this.name == null || this.name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if(oxygen < 0){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }
    protected void setCanBreath(boolean canBreath) {
        this.canBreath = canBreath;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.canBreath;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.oxygen-=10;
        if(this.oxygen <= 0) {
            this.oxygen = 0;
            this.setCanBreath(false);
        }
    }
}
