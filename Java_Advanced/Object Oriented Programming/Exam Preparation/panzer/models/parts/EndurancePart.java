package panzer.models.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends Parts implements HitPointsModifyingPart {
    private int hitPointsModifier;

    public EndurancePart(String model, double weight, BigDecimal price) {
        super(model, weight, price);
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }
}
