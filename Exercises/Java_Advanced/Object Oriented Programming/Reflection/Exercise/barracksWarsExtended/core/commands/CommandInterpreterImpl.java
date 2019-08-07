package barracksWarsExtended.core.commands;

import barracksWarsExtended.annotations.Inject;
import barracksWarsExtended.interfaces.CommandInterpreter;
import barracksWarsExtended.interfaces.Executable;
import barracksWarsExtended.interfaces.Repository;
import barracksWarsExtended.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    private static final String BASE_COMMAND_PACKAGE="barracksWars.core.commands.";
    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable=null;
        commandName = Character.toUpperCase(commandName.charAt(0))+commandName.substring(1);
        try {
            Class<?> clazz = Class.forName( BASE_COMMAND_PACKAGE+ commandName);

            Constructor<?> constructor = clazz.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);


            executable= (Executable) constructor.newInstance((Object) data);

            Field[] fields = clazz.getDeclaredFields();
            Field[] currentFields = this.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                if(field.getDeclaredAnnotations()[0].annotationType() == Inject.class){
                    for (Field currentField : currentFields) {
                        currentField.setAccessible(true);
                        if(field.getType().equals(currentField.getType())) {
                         //  System.out.println(currentField.get(this));
                            field.set(executable, currentField.get(this));
                        }
                    }


                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("Invalid command!");
        }
        return executable;
    }
}
