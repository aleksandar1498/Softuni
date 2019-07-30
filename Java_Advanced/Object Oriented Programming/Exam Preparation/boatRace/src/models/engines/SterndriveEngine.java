package models.engines;

public class SterndriveEngine extends BoatEngineImpl{

    public SterndriveEngine(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
        super.setOutput((horsePower * 7) + displacement);
    }
}
