package models.commands;

import annotations.Inject;
import exceptions.NonExistantModelException;
import exceptions.ParameterArgumentException;
import factories.BoatFactory;
import interfaces.boats.Boat;
import repositories.Database;

import java.lang.reflect.InvocationTargetException;

public class CreateYacht extends Command{
    @Inject
    private Database database;
    @Inject
    private BoatFactory boatFactory;

    protected CreateYacht(String[] data) {
        super(data);
    }

    private Database getDatabase() {
        return database;
    }

    private BoatFactory getBoatFactory() {
        return boatFactory;
    }

    @Override
    public String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException, ParameterArgumentException {
        if(this.getDatabase().getBoatEngineRepository().contains(super.getData()[3])){
            Boat boat = this.getBoatFactory().build(super.getData());
            if(this.getDatabase().getBoatsRepository().add(boat.getModel(),boat)){
                return String.format("%s with model %s registered successfully.",boat.getClass().getSimpleName(),boat.getModel());
            }
        }

        return "operation failed";
    }
}
