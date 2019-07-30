package models.commands;

import annotations.Inject;
import exceptions.NonExistantModelException;
import factories.BoatFactory;
import interfaces.boats.Boat;
import repositories.Database;

import java.lang.reflect.InvocationTargetException;

public class CreateRowBoat extends Command {
    @Inject
    private Database database;
    @Inject
    private BoatFactory boatFactory;

    protected CreateRowBoat(String[] data) {
        super(data);
    }

    private Database getDatabase() {
        return this.database;
    }

    private BoatFactory getBoatFactory() {
        return this.boatFactory;
    }

    @Override
    public String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException {
        Boat boat = this.getBoatFactory().build(super.getData());
        if(this.getDatabase().getBoatsRepository().add(boat.getModel(),boat)){
            return String.format("%s with model %s registered successfully.",boat.getClass().getSimpleName(),boat.getModel());
        }
        return "operation failed";
    }
}
