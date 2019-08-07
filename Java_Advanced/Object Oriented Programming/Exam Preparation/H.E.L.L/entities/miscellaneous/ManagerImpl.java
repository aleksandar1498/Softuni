package hell.entities.miscellaneous;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Heroes;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;
import hell.interfaces.Recipe;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    Map<String, Hero> heroes;

    public ManagerImpl() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        Hero hero = null;
        String name = arguments.get(0);
        String type = arguments.get(1);
        switch (type) {
            case "Barbarian":
                hero = new Barbarian(name);
                break;
            case "Wizard":
                hero = new Wizard(name);
                break;
            case "Assassin":
                hero = new Assassin(name);
                break;
        }
        this.heroes.put(hero.getName(), hero);
        return String.format("Created %s - %s", type, name);

    }

    @Override
    public String addItem(List<String> arguments) {
        String itemName = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitPointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));
        Item item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.heroes.get(heroName).addItem(item);
        return String.format("Added item - %s to Hero - %s", itemName, heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        String recipeName = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitPointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));
        List<String> requiredItems = arguments.subList(7, arguments.size());
        Recipe recipeItem = new RecipeItem(recipeName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
        this.heroes.get(heroName).addRecipe(recipeItem);
        return String.format("Added recipe - %s to Hero - %s", recipeName, heroName);
    }

    @Override
    public String inspect(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        String heroName = arguments.get(0);
        Heroes hero = (Heroes) this.heroes.get(heroName);
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hero: %s, Class: %s", hero.getName(), hero.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", hero.getHitPoints() + hero.getInventory().getTotalHitPointsBonus(), hero.getDamage() + hero.getInventory().getTotalDamageBonus()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d", hero.getStrength() + hero.getInventory().getTotalStrengthBonus()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d", hero.getAgility() + hero.getInventory().getTotalAgilityBonus()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d", hero.getIntelligence() + hero.getInventory().getTotalIntelligenceBonus()))
                .append(System.lineSeparator());
        if (hero.getItems().size() > 0) {
            builder.append("Items:");
            for (Item item : hero.getItems()) {
                builder.append(System.lineSeparator()).append(item.toString());
            }
        }else{
            builder.append("Items: None");
        }

        return builder.toString();
    }

    @Override
    public String quit() throws NoSuchFieldException, IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for (Hero hero : this.heroes.values().stream().sorted((h1, h2) -> {
            int sort = Long.compare(
                    h2.getStrength() + ((Heroes)h2).getInventory().getTotalStrengthBonus()+ h2.getAgility() + ((Heroes)h2).getInventory().getTotalAgilityBonus()+ h2.getIntelligence() + ((Heroes)h2).getInventory().getTotalIntelligenceBonus(),
                    h1.getStrength() + ((Heroes)h1).getInventory().getTotalStrengthBonus()+ h1.getAgility() + ((Heroes)h1).getInventory().getTotalAgilityBonus()+ h1.getIntelligence() + ((Heroes)h1).getInventory().getTotalIntelligenceBonus());
            if (sort == 0) {
                sort = Long.compare(
                        h2.getHitPoints() + ((Heroes)h2).getInventory().getTotalHitPointsBonus() + h2.getDamage()+ ((Heroes)h2).getInventory().getTotalDamageBonus()
                        ,
                        h1.getHitPoints() + ((Heroes)h1).getInventory().getTotalHitPointsBonus()+ h1.getDamage()+ ((Heroes)h1).getInventory().getTotalDamageBonus()
                );
            }
            return sort;
        }).collect(Collectors.toList())) {
            if(i != 1){
                builder.append(System.lineSeparator());
            }
            builder.append(String.format("%d. %s: %s",i,hero.getClass().getSimpleName(),hero.getName()));
            builder.append(System.lineSeparator());
            builder.append(String.format("###HitPoints: %d",hero.getHitPoints()+ ((Heroes)hero).getInventory().getTotalHitPointsBonus()));
            builder.append(System.lineSeparator());
            builder.append(String.format("###Damage: %d",hero.getDamage()+ ((Heroes)hero).getInventory().getTotalDamageBonus()));
            builder.append(System.lineSeparator());
            builder.append(String.format("###Strength: %d",hero.getStrength()+ ((Heroes)hero).getInventory().getTotalStrengthBonus()));
            builder.append(System.lineSeparator());
            builder.append(String.format("###Agility: %d",hero.getAgility()+ ((Heroes)hero).getInventory().getTotalAgilityBonus()));
            builder.append(System.lineSeparator());
            builder.append(String.format("###Intelligence: %d",hero.getIntelligence()+ ((Heroes)hero).getInventory().getTotalIntelligenceBonus()));
            builder.append(System.lineSeparator());
            builder.append(String.format("###Items: %s",(hero.getItems().size() > 0)?hero.getItems().stream().map(Item::getName).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]",""):"None"));
            i++;
        }
        return builder.toString();
    }
}
