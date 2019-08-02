package entities.heroes;

import entities.miscellaneous.HeroInventory;
import entities.miscellaneous.ItemCollection;
import interfaces.Hero;
import interfaces.Inventory;
import interfaces.Item;
import interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;

public abstract class Heroes implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    Heroes(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    @Override
    public Collection<Item> getItems() {
        Collection<Item> items=null;
        Field [] fields = this.inventory.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.getDeclaredAnnotations()[0].annotationType() == ItemCollection.class){
                field.setAccessible(true);
                try {
                    items = (Collection<Item>) field.get(this.inventory);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return items;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }
}
