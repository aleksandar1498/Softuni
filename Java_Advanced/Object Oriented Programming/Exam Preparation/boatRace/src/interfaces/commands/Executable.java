package interfaces.commands;

import exceptions.*;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException, RaceAlreadyExistsException, ParameterArgumentException, NoSetRaceException, InsufficientContestantsException;
}
