package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends Vehicles {
    public Vanguard(String model, double totalWeight, BigDecimal totalPrice, long totalAttack, long totalDefense, long totalHitPoints) {
        super(model, totalWeight*2, totalPrice, (long) (totalAttack*.75), (long) (totalDefense*1.5), (long) (totalHitPoints*1.75));
    }
}
