package spaceStation.repositories;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.BaseAstronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;
    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableList(this.astronauts);
    }

    @Override
    public void add(Astronaut model) {
        if(this.astronauts.stream().noneMatch(a -> a.getName().equals(model.getName()))){
            this.astronauts.add(model);
        }
    }

    @Override
    public boolean remove(Astronaut model) {
        Astronaut astronautToRemove  = astronauts.stream().filter(a -> a.getName().equals(model.getName())).findFirst().orElse(null);
        if(astronautToRemove != null){
            this.astronauts.remove(astronautToRemove);
            return true;
        }
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        return astronauts.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }
}
