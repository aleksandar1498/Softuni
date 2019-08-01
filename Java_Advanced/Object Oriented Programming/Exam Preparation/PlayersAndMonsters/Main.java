import core.ManagerControllerImpl;
import core.interfaces.ManagerController;
import models.battleFields.interfaces.Battlefield;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException {
        ManagerController managerController = new ManagerControllerImpl();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        while (!"Exit".equals(command = reader.readLine())){
            String [] argsCommand = command.split("\\s+");
            String result = "";
            try {
                switch (argsCommand[0]) {
                    case "AddPlayer":
                        result = managerController.addPlayer(argsCommand[1], argsCommand[2]);
                        break;
                    case "AddCard":
                        result = managerController.addCard(argsCommand[1], argsCommand[2]);
                        break;
                    case "AddPlayerCard":
                        result = managerController.addPlayerCard(argsCommand[1], argsCommand[2]);
                        break;
                    case "Fight":
                        result = managerController.fight(argsCommand[1], argsCommand[2]);
                        break;
                    case "Report":
                        result = managerController.report();
                        break;
                }
                System.out.println(result);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
