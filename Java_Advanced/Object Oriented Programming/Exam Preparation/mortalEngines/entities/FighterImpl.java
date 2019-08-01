package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {

    private static final double attackPointsModifier = 50.0;
    private static final double defensePointsModifier = 25.0;
    private static final double DEFAULT_HEALTH_POINTS = 200;
    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.aggressiveMode = false;
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        aggressiveMode = !aggressiveMode;
        if (aggressiveMode) {
            super.setAttackPoints(super.getAttackPoints()+attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints()- defensePointsModifier);
        }else{
            super.setAttackPoints(super.getAttackPoints()-attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints()+ defensePointsModifier);
        }
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format(" *Aggressive Mode(%s)", (this.getAggressiveMode()) ? "ON" : "OFF");

    }
}
