package coreutils.commands;

import annotations.Inject;
import coreutils.Systema;
import interfaces.CommandInterpreter;
import interfaces.Executable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String BASIC_COMMANDS_PATH="coreutils.commands.";
    private Systema system;

    public CommandInterpreterImpl(Systema system) {
        this.system = system;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // We need to find a way to avoid the if with the analyze command
        Class<?> clazz = Class.forName(BASIC_COMMANDS_PATH+commandName);
        Executable executable = (Executable) clazz.getDeclaredConstructor(String[].class).newInstance((Object) data);
        Field [] fields = clazz.getDeclaredFields();

        Field [] currentFields =this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getDeclaredAnnotations()[0].annotationType() == Inject.class){
                for (Field current : currentFields) {
                    current.setAccessible(true);
                    if(field.getType().equals(current.getType())){
                        field.set(executable,current.get(this));
                    }

                }
            }

        }
        return executable;
    }
}
