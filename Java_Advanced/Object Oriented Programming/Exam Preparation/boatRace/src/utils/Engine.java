package utils;

import exceptions.*;
import interfaces.commands.CommandInterpreter;
import interfaces.commands.Executable;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class Engine implements Runnable {
    private Scanner scanner;
    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String command = "";
        while (!"End".equals(command = scanner.nextLine())) {
            String[] args = command.split("\\\\");
            String commandName = args[0];
            Executable executable = null;
            try {
                executable = commandInterpreter.interpretCommand(commandName, args);
                String result = executable.execute();
                if (!result.equals("operation failed")) {
                    System.out.println(result);
                }

            } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | IllegalAccessException | NonExistantModelException | RaceAlreadyExistsException | ParameterArgumentException | InsufficientContestantsException | NoSetRaceException | IllegalArgumentException e) {

                System.out.println(e.getMessage());
            } catch (InvocationTargetException e) {
                System.out.println(e.getCause().getMessage());
            }

        }
        System.out.println();
    }
}
