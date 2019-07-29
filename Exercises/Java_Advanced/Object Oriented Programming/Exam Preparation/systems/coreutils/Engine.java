package coreutils;

import interfaces.CommandInterpreter;
import interfaces.Executable;
import coreutils.commands.CommandInterpreterImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Engine implements Runnable {
    Systema systema;
 CommandInterpreter commandInterpreter;
    public Engine(Systema systema) {
        this.systema = systema;
        this.commandInterpreter = new CommandInterpreterImpl(systema);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!"System Split".equals(command = scanner.nextLine())){
            String commandName = command.substring(0,command.indexOf("("));
            String [] data = command.substring(command.indexOf("(")+1,command.indexOf(")")).split("(, )");
            try {
                Executable executable = this.commandInterpreter.interpretCommand(data,commandName);
                executable.execute();
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        this.systema.getHardwares().values().stream().sorted((h1,h2) -> h2.getClass().getSimpleName().compareTo(h1.getClass().getSimpleName())).forEach(x -> {
            System.out.println(x.toString());
        });
    }
}
