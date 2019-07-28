package coreutils;

import interfaces.CommandInterpreter;
import interfaces.Executable;
import interfaces.Hardware;
import models.commands.CommandInterpreterImpl;
import models.hardware.HeavyHardware;
import models.hardware.PowerHardware;
import models.software.ExpressSoftware;
import models.software.LightSoftware;

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
        while (!"System split".equals(command = scanner.nextLine())){
            String commandName = command.substring(0,command.indexOf("("));
            String [] data = command.substring(command.indexOf("(")+1,command.indexOf(")")).split("(, )");
            try {
                Executable executable = this.commandInterpreter.interpretCommand(data,commandName);
                executable.execute();
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
