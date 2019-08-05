package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private List<Motorcycle> models;

    public MotorcycleRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        Motorcycle motorcycle = this.models.stream().filter(x -> x.getModel().equals(name)).findFirst().orElse(null);
        if(motorcycle == null){
            throw new NullPointerException(String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND,name));
        }
        return motorcycle;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Motorcycle model) {
        if(model == null){
            throw new IllegalArgumentException(ExceptionMessages.MOTORCYCLE_INVALID);
        }
        if(this.models.stream().anyMatch(m -> m.equals(model))){
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS,model.getModel()));
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
//
        return this.models.remove(model);
    }
}
