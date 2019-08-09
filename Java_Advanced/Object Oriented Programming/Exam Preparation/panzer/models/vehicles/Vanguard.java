package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends Vehicles {
    public Vanguard(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints) {
        super(model, weight*2, price, (long) (attack*.75), (long) (defense*1.5), (long) (hitPoints*1.75));
    }
}
