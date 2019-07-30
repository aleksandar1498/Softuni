package models.engines;

public class JetEngine extends BoatEngineImpl {

    public JetEngine(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
        super.setOutput((horsePower * 5) + displacement);
    }
}
