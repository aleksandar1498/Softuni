package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final double attackPointsModifier = 40.0;
    private static final double defensePointsModifier = 30.0;
    private static final double DEFAULT_HEALTH_POINTS=100;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.defenseMode = false;
        this.toggleDefenseMode();
    }


    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        defenseMode = !defenseMode;

        if (defenseMode) {
            super.setAttackPoints(super.getAttackPoints()-attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints()+ defensePointsModifier);
        }else{
            super.setAttackPoints(super.getAttackPoints()+attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints()- defensePointsModifier);
        }
    }

    @Override
    public String toString() {
        String builder = super.toString() + System.lineSeparator() +
                String.format("*Defense Mode(%s)", (this.getDefenseMode()) ? "ON" : "OFF");
        return builder;
    }

    public boolean isDefenseMode() {
        return defenseMode;
    }

    public void setDefenseMode(boolean defenseMode) {
        this.defenseMode = defenseMode;
    }
}
