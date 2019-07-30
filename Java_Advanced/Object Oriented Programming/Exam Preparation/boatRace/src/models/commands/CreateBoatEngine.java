package models.commands;

import annotations.Inject;
import factories.BoatFactory;
import factories.EngineFactory;
import interfaces.boats.Boat;
import interfaces.engines.BoatEngine;
import repositories.Database;
import repositories.Repository;

import java.lang.reflect.InvocationTargetException;

public class CreateBoatEngine extends Command {
    @Inject
    EngineFactory engineFactory;
    @Inject
    Database database;

    protected CreateBoatEngine(String[] data) {
        super(data);
    }

    private EngineFactory getEngineFactory() {
        return engineFactory;
    }

    private Repository<BoatEngine> getBoatEngineRepository() {
        return this.database.getBoatEngineRepository();
    }

    @Override
    public String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BoatEngine boat = this.getEngineFactory().build(super.getData());
        if(this.getBoatEngineRepository().add(boat.getModel(),boat)){
            return String.format("Engine model %s with %d HP and displacement %s cm3 created successfully.",
                    boat.getModel(),boat.getHorsePower(),boat.getDisplacement());
        }
        return "operation failed";
    }
}
