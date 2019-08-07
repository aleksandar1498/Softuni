package hell.entities.miscellaneous;

import hell.interfaces.Manager;

import java.util.Arrays;
import java.util.Scanner;

public class Engine {
    private Manager manager;
    private Scanner scanner;
    public Engine() {
        this.manager = new ManagerImpl();
        this.scanner = new Scanner(System.in);
    }

    public void run() throws NoSuchFieldException, IllegalAccessException {

        while (true){
            String [] commandToken = scanner.nextLine().split("\\s+");
            switch (commandToken[0]){
                case "Hero":
                    System.out.println(this.manager.addHero(Arrays.asList(commandToken).subList(1, commandToken.length)));
                    break;
                case "Item":
                    System.out.println(this.manager.addItem(Arrays.asList(commandToken).subList(1, commandToken.length)));
                    break;
                case "Recipe":
                    System.out.println(this.manager.addRecipe(Arrays.asList(commandToken).subList(1, commandToken.length)));
                    break;
                case "Inspect":
                    System.out.println(this.manager.inspect(Arrays.asList(commandToken).subList(1, commandToken.length)));
                    break;
                case "Quit":
                    System.out.println(this.manager.quit());
                    break;
            }
            if(commandToken[0].equals("Quit")){
                break;
            }

        }

    }
}
