import entities.miscellaneous.InputReaderImpl;
import entities.miscellaneous.ManagerImpl;
import entities.miscellaneous.OutputWriterImpl;
import interfaces.InputReader;
import interfaces.Manager;
import interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();
        Manager manager = new ManagerImpl();
        while (true) {
            String[] commandToken = inputReader.readLine().split(" ");
            List<String> arguments= Arrays.asList(commandToken).subList(1,commandToken.length);
            switch (commandToken[0]) {
                case "Hero":
                   outputWriter.writeLine(manager.addHero(arguments));
                    break;
                case "Item":
                    outputWriter.writeLine(manager.addItem(arguments));
                    break;
                case "Recipe":
                    outputWriter.writeLine(manager.addRecipe(arguments));
                    break;
                case "Inspect":
                    outputWriter.writeLine(manager.inspect(arguments));
                    break;
                case "Quit":
                    System.out.println();
                    outputWriter.writeLine(manager.quit());
                    return;
            }
        }
    }
}