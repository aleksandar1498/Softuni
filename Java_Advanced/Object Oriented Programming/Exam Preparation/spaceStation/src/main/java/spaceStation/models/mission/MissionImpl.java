package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    public MissionImpl() {
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Deque<Astronaut> astronautDeque = new ArrayDeque<>();
        astronauts.forEach(astronautDeque::addLast);
        Deque<String> items = new ArrayDeque<>();
        planet.getItems().forEach(items::addLast);
        if(astronauts.size() == 0 || planet.getItems().size() == 0){
            return;
        }
        Astronaut current = astronautDeque.peek();
        String currentItem = "";
        while (true){
            if(!items.isEmpty()){
                currentItem = items.peek();
            }else{
                return;
            }
            if(current.canBreath()){
                current.breath();
                current.getBag().getItems().add(currentItem);
                items.pop();
            }else{

                astronautDeque.pop();
                if(astronautDeque.isEmpty()){
                    return;
                }
                current = astronautDeque.peek();
            }
        }

    }
}
