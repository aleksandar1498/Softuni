package entities;

import common.OutputMessages;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.Collections;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private Pilot pilot;
    private List<String> targets;

    public BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if(pilot == null){
            throw new IllegalArgumentException("Pilot cannot be null.");
        }

        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    @Override
    public void attack(String target) {
        if(target == null){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }
        this.targets.add(target);
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String toString() {
        String builder = String.format(
                "*Type: %s", this.getClass().getSimpleName().replaceAll("Impl", "")) +
                System.lineSeparator() +
                String.format("*Health: %.2f", this.getHealthPoints()) +
                System.lineSeparator() +
                String.format("*Attack: %.2f", this.getAttackPoints()) +
                System.lineSeparator() +
                String.format("*Defense: %.2f", this.getDefensePoints()) +
                System.lineSeparator() +
                String.format("*Targets: %s", this.getTargets().toString().replaceAll("[\\[\\]]", ""));
        return builder;
    }
}
