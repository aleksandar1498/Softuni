package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RiderRepository implements Repository<Rider> {
    private List<Rider> models;

    public RiderRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        Rider rider = this.models.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(rider == null){
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND,name));
        }
        return rider;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Rider model)
    {
        if(model == null){
                throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
            }
            if(this.models.stream().anyMatch(x -> x.equals(model))){
                throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS,model.getName()));
            }

        this.models.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.models.remove(model);
    }
}
