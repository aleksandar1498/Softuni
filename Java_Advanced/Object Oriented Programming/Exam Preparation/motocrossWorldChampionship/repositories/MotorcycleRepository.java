package motocrossWorldChampionship.repositories;

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
        return this.models.stream().filter(x -> x.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Motorcycle model) {
//        if(this.models.stream().filter(m -> m.equals(model)).count() > 0){
//            throw new IllegalArgumentException()
//        }
    }

    @Override
    public boolean remove(Motorcycle model) {
        return false;
    }
}
