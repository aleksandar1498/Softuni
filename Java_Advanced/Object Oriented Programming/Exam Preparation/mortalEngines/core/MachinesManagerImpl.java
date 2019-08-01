package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;
    private DecimalFormat df = new DecimalFormat("0.00");
    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;

    }


    @Override
    public String hirePilot(String name) {
        if (this.pilots.containsKey(name)) {
            return String.format(OutputMessages.pilotExists, name);
        }
        Pilot pilot = this.pilotFactory.createPilot(name);
        this.pilots.put(name, pilot);
        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }
        Machine machine = this.machineFactory.createTank(name, attackPoints, defensePoints);
        this.machines.put(name, machine);
        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }
        Machine machine = this.machineFactory.createFighter(name, attackPoints, defensePoints);
        this.machines.put(name, machine);
        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilots.containsKey(selectedPilotName)) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }
        if (!this.machines.containsKey(selectedMachineName)) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }
        if (this.machines.get(selectedMachineName).getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        this.pilots.get(selectedPilotName).addMachine(this.machines.get(selectedMachineName));
        this.machines.get(selectedMachineName).setPilot(this.pilots.get(selectedPilotName));
        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)) {
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }
        if (!this.machines.containsKey(defendingMachineName)) {
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }
        Machine attacker = this.machines.get(attackingMachineName);
        Machine defending = this.machines.get(defendingMachineName);
        if(attacker.getAttackPoints() > defending.getDefensePoints()){
            if((defending.getHealthPoints()-attacker.getAttackPoints()) < 0){
                defending.setHealthPoints(0);
            }else{
                defending.setHealthPoints(defending.getHealthPoints() - (attacker.getAttackPoints()-defending.getDefensePoints()));
            }
        }
        attacker.attack(defendingMachineName);

        return String.format(OutputMessages.attackSuccessful, defendingMachineName,attackingMachineName,defending.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if(!this.pilots.containsKey(pilotName)){
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }
        return this.pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if(!this.machines.containsKey(fighterName)){
            return String.format(OutputMessages.machineNotFound, fighterName);

        }
        if(this.machines.containsKey(fighterName) && !this.machines.get(fighterName).getClass().getSimpleName().equals("FighterImpl")){
            return String.format(OutputMessages.notSupportedOperation, fighterName);
        }
        Fighter fighter = (Fighter) this.machines.get(fighterName);
        fighter.toggleAggressiveMode();
        return String.format(OutputMessages.fighterOperationSuccessful,fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if(!this.machines.containsKey(tankName)){
            return String.format(OutputMessages.machineNotFound, tankName);

        }
        if(this.machines.containsKey(tankName) && !this.machines.get(tankName).getClass().getSimpleName().equals("TankImpl")){
            return String.format(OutputMessages.notSupportedOperation, tankName);
        }
        Tank tank = (Tank) this.machines.get(tankName);
        tank.toggleDefenseMode();
        return String.format(OutputMessages.tankOperationSuccessful,tankName);
    }
}
