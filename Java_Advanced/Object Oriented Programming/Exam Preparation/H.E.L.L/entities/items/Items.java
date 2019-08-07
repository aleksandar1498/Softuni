package hell.entities.items;

import hell.interfaces.Item;

public abstract class Items implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    Items(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String toString() {
        //###Item: {item1Name}
        //###+{strengthBonus} Strength
        //###+{agilityBonus} Agility
        //###+{intelligenceBonus} Intelligence
        //###+{hitpointsBonus} HitPoints
        //###+{damageBonus} Damage
        return String.format("###Item: %s", this.getName()) +
                System.lineSeparator() +
                String.format("###+%d Strength", this.getStrengthBonus()) +
                System.lineSeparator() +
                String.format("###+%d Agility", this.getAgilityBonus()) +
                System.lineSeparator() +
                String.format("###+%d Intelligence", this.getIntelligenceBonus()) +
                System.lineSeparator() +
                String.format("###+%d HitPoints", this.getHitPointsBonus()) +
                System.lineSeparator() +
                String.format("###+%d Damage", this.getDamageBonus());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }
}
