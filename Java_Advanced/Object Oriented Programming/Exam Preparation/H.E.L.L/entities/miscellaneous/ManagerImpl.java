package entities.miscellaneous;

import entities.heroes.Assassin;
import entities.heroes.Barbarian;
import entities.heroes.Heroes;
import entities.heroes.Wizard;
import entities.items.CommonItem;
import entities.items.RecipeItem;
import interfaces.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {

    private Map<String, Hero> heroes;

    public ManagerImpl() {

        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        Hero hero = null;
        String name = arguments.get(0);
        String type = arguments.get(1);
        switch (type) {
            case "Assassin":
                hero = new Assassin(name);
                break;
            case "Barbarian":
                hero = new Barbarian(name);
                break;
            case "Wizard":
                hero = new Wizard(name);
                break;
        }
        this.heroes.putIfAbsent(name, hero);
        return String.format("Created %s - %s", hero.getClass().getSimpleName(), name);
    }

    @Override
    public String addItem(List<String> arguments) {
        String name = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitpointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));
        Item item = new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus);
        this.heroes.get(heroName).addItem(item);
        return String.format("Added item - %s to Hero - %s", name, heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        String name = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitpointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));
        List<String> requiredItems = arguments.subList(7, arguments.size());
        Recipe recipe = new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus, requiredItems);
        this.heroes.get(heroName).addRecipe(recipe);
        return String.format("Added recipe - %s to Hero - %s", name, heroName);
    }

    @Override
    public String inspect(List<String> arguments) {

        Hero hero = this.heroes.get(arguments.get(0));
        StringBuilder builder = new StringBuilder(hero.toString());
        builder.append(System.lineSeparator());
        builder.append((hero.getItems().size() > 0) ? "Items:" : "Items: None");
        hero.getItems().forEach(item -> {
            builder.append(System.lineSeparator());
            builder.append(item.toString());
        });
        return builder.toString();
    }

    @Override
    public String quit() {
        int i = 1;
        StringBuilder builder = new StringBuilder();
        for (Hero hero : this.heroes.entrySet().stream().sorted((h1, h2) -> {
            long sumOfStatsFirstHero = h1.getValue().getStrength() + h1.getValue().getItems().stream().mapToLong(Item::getHitPointsBonus).sum() + h1.getValue().getAgility() + h1.getValue().getItems().stream().mapToLong(Item::getAgilityBonus).sum() + h1.getValue().getIntelligence() + h1.getValue().getItems().stream().mapToLong(Item::getIntelligenceBonus).sum();
            long sumOfStatsSecondHero = h2.getValue().getStrength() + h2.getValue().getItems().stream().mapToLong(Item::getHitPointsBonus).sum() + h2.getValue().getAgility() + h2.getValue().getItems().stream().mapToLong(Item::getAgilityBonus).sum() + h2.getValue().getIntelligence() + h2.getValue().getItems().stream().mapToLong(Item::getIntelligenceBonus).sum();
            int sort = Long.compare(sumOfStatsSecondHero, sumOfStatsFirstHero);
            if (sort == 0) {
                sort = Long.compare(h2.getValue().getHitPoints() + h2.getValue().getDamage(), h1.getValue().getHitPoints() + h1.getValue().getDamage());
            }
            return sort;
        }).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> newValue,
                LinkedHashMap::new)).values()) {
            builder.append(i).append(". ")
                    .append(String.format("Hero: %s, Class: %s", hero.getName(), hero.getClass().getSimpleName()))
                    .append(System.lineSeparator())
                    .append(String.format("###HitPoints: %d, Damage: %d", hero.getHitPoints() + hero.getItems().stream().mapToLong(Item::getHitPointsBonus).sum(), hero.getDamage()+ hero.getItems().stream().mapToLong(Item::getDamageBonus).sum()))
                    .append(System.lineSeparator())
                    .append(String.format("###Strength: %d", hero.getStrength()+ hero.getItems().stream().mapToLong(Item::getStrengthBonus).sum()))
                    .append(System.lineSeparator())
                    .append(String.format("###Agility: %d", hero.getAgility()+ hero.getItems().stream().mapToLong(Item::getAgilityBonus).sum()))
                    .append(System.lineSeparator())
                    .append(String.format("###Intelligence: %d", hero.getIntelligence()+ hero.getItems().stream().mapToLong(Item::getIntelligenceBonus).sum()))
                    .append(System.lineSeparator())
                    .append("###Items: ").append((hero.getItems().size() > 0) ? hero.getItems().stream().map(Item::getName).collect(Collectors.joining()) : "None")
                    .append(System.lineSeparator());
            i++;

        }
        return builder.toString();
    }
}
