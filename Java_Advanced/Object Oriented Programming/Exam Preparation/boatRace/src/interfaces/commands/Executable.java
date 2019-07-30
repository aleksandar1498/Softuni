package interfaces.commands;

import exceptions.NoSetRaceException;
import exceptions.NonExistantModelException;
import exceptions.ParameterArgumentException;
import exceptions.RaceAlreadyExistsException;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException, RaceAlreadyExistsException, ParameterArgumentException, NoSetRaceException;
}
