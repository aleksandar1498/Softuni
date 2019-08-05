package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.common.ExceptionMessages;
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
        Race race = this.models.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(race == null){
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND,name));
        }
        return race;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Race model) {
       if(this.models.stream().anyMatch(x -> x.equals(model))){
           throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,model.getName()));
       }
       this.models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.models.remove(model);
    }
}
