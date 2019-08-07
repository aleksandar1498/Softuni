import factories.BoatFactory;
import factories.EngineFactory;
import interfaces.boats.Boat;
import interfaces.commands.CommandInterpreter;
import interfaces.engines.BoatEngine;
import models.RepositoryImpl;
import models.commands.CommandIntepreterImpl;
import repositories.Repository;
import utils.Engine;

public class Main {
    public static void main(String[] args) {
        BoatFactory boatFactory = new BoatFactory();
        EngineFactory engineFactory = new EngineFactory();
        Repository<BoatEngine> boatEngineRepository = new RepositoryImpl<>();
        Repository<Boat> boatsRepository = new RepositoryImpl<>();

        CommandInterpreter commandInterpreter= new CommandIntepreterImpl(boatFactory,engineFactory, boatEngineRepository, boatsRepository);
        Engine engine = new Engine(commandInterpreter);
        engine.run();
    }
}
