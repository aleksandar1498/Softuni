package models.engines;

import exceptions.ModelArgumentException;
import exceptions.ParameterArgumentException;

public class SterndriveEngine extends BoatEngineImpl{

    public SterndriveEngine(String model, Integer horsePower, Integer displacement) throws ParameterArgumentException, ModelArgumentException {
        super(model, horsePower, displacement);
        // output
        super.setOutput((horsePower * 7) + displacement);
    }
}
