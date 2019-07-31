package models.commands;

import annotations.Inject;
import exceptions.NonExistantModelException;
import exceptions.ParameterArgumentException;
import exceptions.RaceAlreadyExistsException;
import interfaces.races.Race;
import models.races.RaceImpl;

import java.lang.reflect.InvocationTargetException;

public class OpenRace extends Command {
    @Inject
    private Race race;
    protected OpenRace(String[] data) {
        super(data);
    }



    @Override
    public String execute() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException, RaceAlreadyExistsException, ParameterArgumentException {
        if(!this.race.isOpen()){
            //\<distance>\<windSpeed>\<oceanCurrentSpeed>\<allowsMotorboats>
            int distance = Integer.parseInt(super.getData()[1]);
            int windSpeed = Integer.parseInt(super.getData()[2]);
            int oceanCurrentSpeed = Integer.parseInt(super.getData()[3]);
            boolean allowsMotorboats= Boolean.parseBoolean(super.getData()[4]);
            this.race.setDistance(distance);
            this.race.setWindSpeed(windSpeed);
            this.race.setOceanSpeed(oceanCurrentSpeed);
            this.race.setMotorboatsAreAllowed(allowsMotorboats);
            this.race.open();
            return String.format("A new race with distance %d meters, wind speed %d m/s and ocean current speed %d m/s has been set."
                    ,distance
                    ,windSpeed
                    ,oceanCurrentSpeed);

        }
        throw new RaceAlreadyExistsException();
    }
}
