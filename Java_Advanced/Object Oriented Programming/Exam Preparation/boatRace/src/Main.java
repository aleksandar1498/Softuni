import exceptions.ParameterArgumentException;
import factories.BoatFactory;
import factories.EngineFactory;
import interfaces.boats.Boat;
import interfaces.commands.CommandInterpreter;
import interfaces.engines.BoatEngine;
import models.RepositoryImpl;
import models.commands.CommandIntepreterImpl;
import repositories.Database;
import repositories.Repository;
import utils.Engine;

public class Main {
    public static void main(String[] args) throws ParameterArgumentException {

        Repository<BoatEngine> boatEngineRepository = new RepositoryImpl<>();
        Repository<Boat> boatsRepository = new RepositoryImpl<>();
        Database database = new Database(boatEngineRepository,boatsRepository);
        BoatFactory boatFactory = new BoatFactory(database);
        EngineFactory engineFactory = new EngineFactory();
        CommandInterpreter commandInterpreter= new CommandIntepreterImpl(boatFactory,engineFactory, database);
        Engine engine = new Engine(commandInterpreter);
        engine.run();
    }
}
