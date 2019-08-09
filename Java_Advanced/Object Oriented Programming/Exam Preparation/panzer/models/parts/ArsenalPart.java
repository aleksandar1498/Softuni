package panzer.models.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends Parts implements AttackModifyingPart {
    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price) {
        super(model, weight, price);
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }
}
