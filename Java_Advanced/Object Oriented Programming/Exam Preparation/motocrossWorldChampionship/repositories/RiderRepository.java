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
        return null;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Rider model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return false;
    }
}
