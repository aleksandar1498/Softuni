package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends Vehicles {
    public Revenger(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints) {
        super(model, weight, price.multiply(BigDecimal.valueOf(1.5)), (long) (attack*2.5), (long) (defense*.5), (long) (hitPoints*.5));
    }
}
