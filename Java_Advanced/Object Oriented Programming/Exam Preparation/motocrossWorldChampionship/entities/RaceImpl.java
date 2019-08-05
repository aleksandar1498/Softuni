package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Repository<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new RiderRepository();
    }

    private void setLaps(int laps) {
        if(laps < 1){
            throw new  IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_LAPS);
        }
        this.laps = laps;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty() || name.length() < 5){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME,name,5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders.getAll();
    }

    @Override
    public void addRider(Rider rider) {
        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        }
        if (this.riders.getAll().contains(rider)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED, rider.getName(), this.getName()));
        }
        this.riders.add(rider);
    }

}
