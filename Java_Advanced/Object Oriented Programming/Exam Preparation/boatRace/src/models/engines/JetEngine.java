package models.engines;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;

public class JetEngine extends BoatEngineImpl {

    public JetEngine(String model, Integer horsePower, Integer displacement) throws ParameterArgumentException, ModelArgumentException {
        super(model, horsePower, displacement);
        super.setOutput((horsePower * 5) + displacement);
    }
}
