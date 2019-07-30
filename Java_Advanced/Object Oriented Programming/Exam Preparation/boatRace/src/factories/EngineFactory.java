package factories;

import interfaces.engines.BoatEngine;
import interfaces.factories.Factory;
import models.engines.BoatEngineImpl;
import utils.Engine;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EngineFactory implements Factory<BoatEngine> {
    private static final String ENGINES_BASE_PATH="models.engines.";
    @Override
    public BoatEngine build(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String type=args[4];
        String model = args[1];
        Integer horsePower = Integer.parseInt(args[2]);
        Integer displacement = Integer.parseInt(args[3]);
        Class<? extends BoatEngineImpl> engineClass= (Class<? extends BoatEngineImpl>) Class.forName(ENGINES_BASE_PATH+type+"Engine");
        Constructor[] cnsr = engineClass.getDeclaredConstructors();
        BoatEngine boatEngine = engineClass.getDeclaredConstructor(String.class,Integer.class,Integer.class).newInstance(model,horsePower,displacement);

        return boatEngine;
    }
}
