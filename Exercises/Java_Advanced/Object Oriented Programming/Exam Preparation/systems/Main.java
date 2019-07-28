import coreutils.Engine;
import coreutils.Systema;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        Systema systema = new Systema(new LinkedHashMap<>());
        Engine engine = new Engine(systema);
        engine.run();
    }
}
