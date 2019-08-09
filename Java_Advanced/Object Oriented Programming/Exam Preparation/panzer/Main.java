package panzer;

import panzer.contracts.Manager;
import panzer.core.ManagerImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new ManagerImpl();
        while (true) {
            List<String> commandToken = Arrays.asList(scanner.nextLine().split("\\s+"));
            switch (commandToken.get(0)) {
                case "Vehicle":
                    System.out.println(manager.addVehicle(commandToken.subList(1, commandToken.size())));
                    break;
                case "Part":
                    System.out.println(manager.addPart(commandToken.subList(1,commandToken.size())));
                    break;
                case "Battle":
                    System.out.println(manager.battle(commandToken.subList(1,commandToken.size())));
                    break;
                case "Inspect":
                    System.out.println(manager.inspect(commandToken.subList(1,commandToken.size())));
                    break;
                case "Terminate":
                    System.out.println(manager.terminate(new ArrayList<>()));
                    return;
            }


        }
    }
}
