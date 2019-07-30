package models.races;

import exceptions.DuplicateModelException;
import exceptions.ParameterArgumentException;
import interfaces.boats.Boat;
import interfaces.races.Race;
import models.RepositoryImpl;
import repositories.Repository;

import java.util.Collections;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanSpeed;
    private boolean motorboatsAreAllowed;
    private boolean opened;
    private Repository<Boat> participants;

    public RaceImpl() {
        this.close();
    }

    public boolean isMotorboatsAreAllowed() {
        return motorboatsAreAllowed;
    }

    @Override
    public void add(Boat boat) throws DuplicateModelException {
        if(!this.getParticipants().contains(boat.getModel())){
            this.getParticipants().add(boat.getModel(),boat);
        }
        throw  new DuplicateModelException("");
    }

    @Override
    public Repository<Boat> getParticipants() {
        return this.participants;
    }

    public void setDistance(int distance) throws ParameterArgumentException {
        if(distance < 0){
            throw new ParameterArgumentException("Distance");
        }
        this.distance = distance;
    }

    @Override
    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public void setOceanSpeed(int oceanSpeed) {
        this.oceanSpeed = oceanSpeed;
    }

    @Override
    public void setMotorboatsAreAllowed(boolean motorboatsAreAllowed) {
        this.motorboatsAreAllowed = motorboatsAreAllowed;
    }

    @Override
    public void open() {
        this.opened = true;
    }

    @Override
    public void close() {
        this.opened = false;
    }


    @Override
    public boolean isOpen() {
        return this.opened;
    }


}
