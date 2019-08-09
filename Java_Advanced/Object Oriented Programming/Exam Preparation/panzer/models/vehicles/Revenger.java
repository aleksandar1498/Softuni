package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends Vehicles {
    public Revenger(String model, double totalWeight, BigDecimal totalPrice, long totalAttack, long totalDefense, long totalHitPoints) {
        super(model, totalWeight, totalPrice.multiply(BigDecimal.valueOf(1.5)), (long) (totalAttack*2.5), (long) (totalDefense*.5), (long) (totalHitPoints*.5));
    }
}
