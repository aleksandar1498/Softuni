package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlanetRepository implements Repository<Planet>{
    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableList(this.planets);
    }

    @Override
    public void add(Planet model) {
        if(this.planets.stream().noneMatch(a -> a.getName().equals(model.getName()))){
            this.planets.add(model);
        }
    }

    @Override
    public boolean remove(Planet model) {
        Planet astronautToRemove  = planets.stream().filter(a -> a.getName().equals(model.getName())).findFirst().orElse(null);
        if(astronautToRemove != null){
            this.planets.remove(astronautToRemove);
            return true;
        }
        return false;
    }

    @Override
    public Planet findByName(String name) {
        return planets.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }
}
