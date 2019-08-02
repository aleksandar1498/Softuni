package entities.miscellaneous;

import entities.items.CommonItem;
import interfaces.Inventory;
import interfaces.Item;
import interfaces.Recipe;

import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<String, Item>();
        this.recipeItems = new LinkedHashMap<String, Recipe>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getStrengthBonus).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getAgilityBonus).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getIntelligenceBonus).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getHitPointsBonus()).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getDamageBonus()).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<String>(recipe.getRequiredItems());

            System.out.println("CHECKs");
            for (Item item : this.commonItems.values()) {
                requiredItems.remove(item.getName());
            }

            if(requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
            }
        }
    }

    private void combineRecipe(Recipe recipe) {

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        Item newItem = new CommonItem(recipe.getName(),
                recipe.getStrengthBonus(),
                recipe.getAgilityBonus(),
                recipe.getIntelligenceBonus(),
                recipe.getHitPointsBonus(),
                recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);
    }
}
