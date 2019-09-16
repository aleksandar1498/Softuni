package spaceStation;

import spaceStation.core.Controller;
import spaceStation.core.ControllerImpl;
import spaceStation.core.Engine;
import spaceStation.core.EngineImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Repository astronaut = new AstronautRepository();
        Repository planet = new PlanetRepository();
        Controller controller = new ControllerImpl(astronaut,planet);
        Engine engine = new EngineImpl(controller);
        engine.run();

    }
}
