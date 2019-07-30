package models.commands;

import annotations.Inject;
import exceptions.ParameterArgumentException;
import factories.BoatFactory;
import factories.EngineFactory;
import interfaces.boats.Boat;
import interfaces.commands.CommandInterpreter;
import interfaces.commands.Executable;
import interfaces.engines.BoatEngine;
import interfaces.races.Race;
import models.races.RaceImpl;
import repositories.Database;
import repositories.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandIntepreterImpl implements CommandInterpreter {
    private static final String BASE_COMMANDS_PATH = "models.commands.";
    //CreateBoatEngine\&lt;model&gt;\&lt;horsePower&gt;\&lt;displacement&gt;\&lt;type&gt;
    //CreateRowBoat\&lt;model&gt;\&lt;weight&gt;\&lt;oars&gt;
    // CreateSailBoat\&lt;model&gt;\&lt;weight&gt;\&lt;sailEfficiency&gt;
    // CreatePowerBoat\&lt;model&gt;\&lt;weight&gt;\&lt;boatEngine&gt;\&lt;secondEngine&gt;
    // CreateYacht\&lt;model&gt;\&lt;weight&gt;\&lt;boatEngine&gt;\&lt;cargoWeight&gt;
    private BoatFactory boatFactory;
    private EngineFactory engineFactory;
    private Database database;
    private Race race;

    public CommandIntepreterImpl(BoatFactory boatFactory, EngineFactory engineFactory,Database database) throws ParameterArgumentException {
        this.boatFactory = boatFactory;
        this.engineFactory = engineFactory;
        this.database = database;
        this.race = new RaceImpl();
    }

    @Override
    public Executable interpretCommand(String commandName, String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> commandClass = Class.forName(BASE_COMMANDS_PATH + commandName);
        Executable executable = (Executable) commandClass.getDeclaredConstructor(String[].class).newInstance((Object) args);
        Field[] commandClassFields = commandClass.getDeclaredFields();
        Field[] currentClassFields = this.getClass().getDeclaredFields();
        for (Field commandClassField : commandClassFields) {
            commandClassField.setAccessible(true);
            if(commandClassField.getDeclaredAnnotations()[0].annotationType().equals(Inject.class)){
                for (Field currentClassField : currentClassFields) {
                    if(currentClassField.getType().equals(commandClassField.getType())){
                        commandClassField.set(executable,currentClassField.get(this));
                    }
                }
            }
        }

        return executable;
    }
}
