package cresla;

import cresla.entities.InputReaderImpl;
import cresla.entities.ManagerImpl;
import cresla.entities.modules.CryogenRod;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        InputReader inputReader = new InputReaderImpl();
        Manager manager = new ManagerImpl();
        while (true){
            //Reactor Cryo 10000 10000
            //Module 1 HeatProcessor 10000
            //Report 1
            List<String> commandToken = Arrays.asList(inputReader.readLine().split("\\s+"));
            switch (commandToken.get(0)){
                case "Reactor":
                    System.out.println(manager.reactorCommand(commandToken.subList(1, commandToken.size())));
                    break;
                case "Module":
                    System.out.println(manager.moduleCommand(commandToken.subList(1, commandToken.size())));
                    break;
                case "Report":
                    System.out.println(manager.reportCommand(commandToken.subList(1, commandToken.size())));
                    break;
                case "Exit":
                    System.out.println(manager.exitCommand(commandToken));
                    return;
            }
        }
    }
}
