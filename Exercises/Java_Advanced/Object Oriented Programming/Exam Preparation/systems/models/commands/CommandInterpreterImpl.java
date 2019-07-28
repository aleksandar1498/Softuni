package models.commands;

import annotations.Inject;
import coreutils.Systema;
import interfaces.CommandInterpreter;
import interfaces.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String BASIC_COMMANDS_PATH="models.commands.";
    private Systema system;

    public CommandInterpreterImpl(Systema system) {
        this.system = system;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName(BASIC_COMMANDS_PATH+commandName);
        Executable executable = (Executable) clazz.getDeclaredConstructor(String[].class).newInstance((Object) data);
        Field [] fields = clazz.getDeclaredFields();
        Field [] currentFields = this.system.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getDeclaredAnnotations()[0].annotationType() == Inject.class){
                for (Field current : currentFields) {
                    current.setAccessible(true);
                    if(field.getType().equals(current.getType())){
                        field.set(executable,(Map)current.get(this.system.getHardwares()));
                    }

                }
            }

        }
        System.out.println();
        return executable;
    }
}
