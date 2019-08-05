package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RaceRepository implements Repository<Race> {
    private List<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Race model) {

    }

    @Override
    public boolean remove(Race model) {
        return false;
    }
}
