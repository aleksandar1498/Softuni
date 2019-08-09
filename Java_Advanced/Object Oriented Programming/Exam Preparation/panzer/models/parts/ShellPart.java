package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends Parts implements DefenseModifyingPart {
    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price) {
        super(model, weight, price);
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }
}
