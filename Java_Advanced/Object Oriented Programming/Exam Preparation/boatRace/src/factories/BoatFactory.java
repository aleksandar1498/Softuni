package factories;

import annotations.Inject;
import annotations.Motorboat;
import annotations.MultiMotorboat;
import exceptions.NonExistantModelException;
import exceptions.ParameterArgumentException;
import interfaces.boats.Boat;
import interfaces.engines.BoatEngine;
import interfaces.factories.Factory;
import models.boats.BoatImpl;
import models.boats.PowerBoat;
import repositories.Database;
import repositories.Repository;

import java.lang.reflect.InvocationTargetException;

public class BoatFactory implements Factory<Boat> {
    private Database database;
    private static final String BASE_BOAT_PATH = "models.boats.";

    public BoatFactory(Database database) {
        this.database = database;
    }

    @Override
    public Boat build(String[] args) throws ClassNotFoundException, NonExistantModelException, NoSuchMethodException, IllegalAccessException, ParameterArgumentException, InstantiationException, InvocationTargetException {
        String boatType = args[0].replaceAll("Create", "");
        Boat boat = null;
        String model = args[1];
        Integer weight = Integer.parseInt(args[2]);
        Class<? extends BoatImpl> clazz = (Class<? extends BoatImpl>) Class.forName(BASE_BOAT_PATH + boatType);
        if (clazz.getDeclaredAnnotations().length > 0) {
            if (clazz.getDeclaredAnnotations()[0].annotationType().equals(Motorboat.class)) {
                BoatEngine boatEngine = this.database.getBoatEngineRepository().get(args[3]);
                Integer cargo = Integer.parseInt(args[4]);
                boat = clazz.getDeclaredConstructor(String.class, Integer.class, BoatEngine.class, Integer.class).newInstance(model, weight, boatEngine, cargo);
            } else if (clazz.getDeclaredAnnotations()[0].annotationType().equals(MultiMotorboat.class)) {
                BoatEngine boatEngine = this.database.getBoatEngineRepository().get(args[3]);
                BoatEngine boatEngine2 = this.database.getBoatEngineRepository().get(args[4]);

                boat = clazz.getDeclaredConstructor(String.class, Integer.class, BoatEngine.class, BoatEngine.class).newInstance(model, weight, boatEngine, boatEngine2);
            }
        } else {

            Integer additionalParameter = Integer.parseInt(args[3]);

            boat = clazz.getDeclaredConstructor(String.class, Integer.class, Integer.class).newInstance(model, weight, additionalParameter);


        }

        return boat;
    }
}
