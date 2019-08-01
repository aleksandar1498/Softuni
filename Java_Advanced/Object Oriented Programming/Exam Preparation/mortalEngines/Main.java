import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
        String command ="";
        while (!"Over".equals(command = scanner.nextLine())){
            String [] argsCommand=command.split("\\s+");
            switch (argsCommand[0]){
                case "Hire":
                    machinesManager.hirePilot(argsCommand[1]);
                    break;
                case "ManufactureTank":
                    machinesManager.manufactureTank(argsCommand[1],Double.parseDouble(argsCommand[2]),Double.parseDouble(argsCommand[3]));
                    break;
                case "ManufactureFighter":
                    machinesManager.manufactureFighter(argsCommand[1],Double.parseDouble(argsCommand[2]),Double.parseDouble(argsCommand[3]));
                    break;
                case "Engage":
                    machinesManager.engageMachine(argsCommand[1],argsCommand[2]);
                    break;
                case "Attack":
                    machinesManager.attackMachines(argsCommand[1],argsCommand[2]);
                    break;
                case "AggressiveMode":
                    machinesManager.toggleFighterAggressiveMode(argsCommand[1]);
                    break;
                case "DefenseMode":
                    machinesManager.toggleTankDefenseMode(argsCommand[1]);
                    break;
                case "Report":
                    machinesManager.pilotReport(argsCommand[1]);
                    break;
            }
        }
    }
}
