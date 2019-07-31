package models.commands;

import annotations.Inject;
import exceptions.NoSetRaceException;
import exceptions.NonExistantModelException;
import exceptions.ParameterArgumentException;
import exceptions.RaceAlreadyExistsException;
import interfaces.boats.Boat;
import interfaces.races.Race;
import repositories.Database;

import java.lang.reflect.InvocationTargetException;

public class SignUpBoat extends Command {
    @Inject
    Database database;
    @Inject
    Race race;
    protected SignUpBoat(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException, RaceAlreadyExistsException, ParameterArgumentException, NoSetRaceException, IllegalArgumentException {
        if(!this.race.isOpen()){
            throw new NoSetRaceException();
        }
        Boat boat = null;
        if(this.database.getBoatsRepository().contains(super.getData()[1])){
            boat = this.database.getBoatsRepository().get(super.getData()[1]);
            if(!this.race.isMotorboatsAreAllowed()){
                if(boat.getClass().getDeclaredAnnotations().length > 0){
                    throw new IllegalArgumentException("The specified boat does not meet the race constraints.");
                }
            }

        }else{
            return "operation failed";
        }
        this.race.getParticipants().add(boat.getModel(),boat);
        return String.format("Boat with model %s has signed up for the current Race.",boat.getModel());
    }
}
