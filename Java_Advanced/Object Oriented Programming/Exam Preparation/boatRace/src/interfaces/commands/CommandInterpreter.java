package interfaces.commands;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {
    Executable interpretCommand(String commandName,String [] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
