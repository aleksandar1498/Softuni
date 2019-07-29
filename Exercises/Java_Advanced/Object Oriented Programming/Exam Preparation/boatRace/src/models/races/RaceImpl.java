package models.races;

import exceptions.DuplicateModelException;
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
    private Repository<Boat> participants;
    public RaceImpl(int distance, int windSpeed, int oceanSpeed, boolean motorboatsAreAllowed) {
        this.distance = distance;
        this.windSpeed = windSpeed;
        this.oceanSpeed = oceanSpeed;
        this.motorboatsAreAllowed = motorboatsAreAllowed;
        this.participants = new RepositoryImpl<>();
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
}
