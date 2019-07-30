package utils;

import interfaces.commands.CommandInterpreter;
import interfaces.commands.Executable;

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
            args = Arrays.copyOfRange(args,1,args.length);
            System.out.println();
            Executable executable = null;
            try {
                executable = commandInterpreter.interpretCommand(commandName, args);
                String result = executable.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
}
