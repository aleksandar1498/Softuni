package models.commands;

import factories.BoatFactory;
import factories.EngineFactory;
import interfaces.boats.Boat;
import interfaces.commands.CommandInterpreter;
import interfaces.commands.Executable;
import interfaces.engines.BoatEngine;
import repositories.Repository;

import java.lang.reflect.InvocationTargetException;

public class CommandIntepreterImpl implements CommandInterpreter {
    private static final String BASE_COMMANDS_PATH="models.commands.";
    //CreateBoatEngine\&lt;model&gt;\&lt;horsePower&gt;\&lt;displacement&gt;\&lt;type&gt;
    //CreateRowBoat\&lt;model&gt;\&lt;weight&gt;\&lt;oars&gt;
    // CreateSailBoat\&lt;model&gt;\&lt;weight&gt;\&lt;sailEfficiency&gt;
    // CreatePowerBoat\&lt;model&gt;\&lt;weight&gt;\&lt;boatEngine&gt;\&lt;secondEngine&gt;
    // CreateYacht\&lt;model&gt;\&lt;weight&gt;\&lt;boatEngine&gt;\&lt;cargoWeight&gt;
    private BoatFactory boatFactory;
    private EngineFactory engineFactory;
    private Repository<BoatEngine> boatEngineRepository;
    private Repository<Boat> boatsRepository;
    public CommandIntepreterImpl(BoatFactory boatFactory, EngineFactory engineFactory, Repository<BoatEngine> boatEngineRepository, Repository<Boat> boatsRepository) {
        this.boatFactory = boatFactory;
        this.engineFactory = engineFactory;
        this.boatEngineRepository = boatEngineRepository;
        this.boatsRepository = boatsRepository;
    }

    @Override
    public Executable interpretCommand(String commandName, String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> commandClass = Class.forName(BASE_COMMANDS_PATH+commandName);
        Executable executable = (Executable) commandClass.getDeclaredConstructor(String[].class).newInstance((Object) args);

        return null;
    }
}
