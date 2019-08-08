package callofduty.core;

import callofduty.interfaces.MissionManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Engine {
    private MissionManager missionManager;
    private Scanner scanner;

    public Engine() {

        this.missionManager = new MissionManagerImpl();
        this.scanner = new Scanner(System.in);
    }

    public void run() throws NoSuchFieldException, IllegalAccessException {
        while (true){
            List<String> commandToken = Arrays.asList(scanner.nextLine().split("\\s+"));
            switch (commandToken.get(0)){
                case "Agent":
                    System.out.println(missionManager.agent(commandToken.subList(1, commandToken.size())));
                    break;
                case "Request":
                    System.out.println(missionManager.request(commandToken.subList(1, commandToken.size())));
                    break;
                case "Status":
                    System.out.println(missionManager.status(commandToken.subList(1, commandToken.size())));
                    break;
                case "Complete":
                    System.out.println(missionManager.complete(commandToken.subList(1, commandToken.size())));
                    break;
                case "Over":
                    System.out.println(missionManager.over(commandToken.subList(1, commandToken.size())));
                    return;
            }
        }
    }
}
