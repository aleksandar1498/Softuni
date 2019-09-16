package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int exploredPlanets = 0;

    public ControllerImpl(Repository<Astronaut> astronautRepository, Repository<Planet> planetRepository) {
        this.astronautRepository = astronautRepository;
        this.planetRepository = planetRepository;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet =(PlanetImpl) new PlanetImpl(planetName);
        planet.setItems(Arrays.asList(items));
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        if(astronaut == null){
            return String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST,astronautName);
        }
        if(this.astronautRepository.remove(astronaut)){
            return String.format(ConstantMessages.ASTRONAUT_RETIRED,astronautName);
        }

        return "";
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = this.planetRepository.findByName(planetName);
        if(planet != null){
            List<Astronaut> suitables = this.astronautRepository.getModels().stream().filter(x -> x.getOxygen() > 60).collect(Collectors.toList());
            int astronautsInExpedition = suitables.size();
            if(astronautsInExpedition == 0){
                throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
            }

            Mission mission = new MissionImpl();
            mission.explore(planet,suitables);
            this.exploredPlanets++;
            return String.format(ConstantMessages.PLANET_EXPLORED,planetName,Math.abs(suitables.size()-astronautsInExpedition));

        }

        return "";
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED,this.exploredPlanets)).append(System.lineSeparator());
        stringBuilder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_INFO,this.exploredPlanets));
        for (Astronaut model : this.astronautRepository.getModels()) {
            stringBuilder.append(System.lineSeparator()).append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME,model.getName())).append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN,model.getOxygen())).append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,(model.getBag().getItems().size() > 0)?String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER,model.getBag().getItems()):"none"));

        }
        return stringBuilder.toString();
    }
}
