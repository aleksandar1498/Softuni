package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;

import java.util.Scanner;

public class EngineImpl implements Engine {
    ChampionshipController championshipController;
    Scanner scanner;

    public EngineImpl() {
        this.championshipController = new ChampionshipControllerImpl();
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {

        String command = "";
        while (!"End".equals(command = scanner.nextLine())) {
            String[] commandToken = command.split("\\s+");
            String result = "";
            try {
                switch (commandToken[0]) {
                    case "CreateRider":
                        result = this.championshipController.createRider(commandToken[1]);
                        break;
                    case "CreateMotorcycle":
                        result = this.championshipController.createMotorcycle(commandToken[1], commandToken[2], Integer.parseInt(commandToken[3]));
                        break;
                    case "CreateRace":
                        result = this.championshipController.createRace(commandToken[1], Integer.parseInt(commandToken[2]));
                        break;
                    case "AddMotorcycleToRider":
                        result = this.championshipController.addMotorcycleToRider(commandToken[1], commandToken[2]);
                        break;
                    case "AddRiderToRace":
                        result = this.championshipController.addRiderToRace(commandToken[1], commandToken[2]);
                        break;
                    case "StartRace":
                        result = this.championshipController.startRace(commandToken[1]);
                        break;
                }
                System.out.println(result);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
