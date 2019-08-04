package heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    @Test
    public void dataShouldBeInitializedCorrectly() throws NoSuchFieldException, IllegalAccessException {
        HeroRepository heroRepository = new HeroRepository();
        Field field = heroRepository.getClass().getDeclaredField("data");
        field.setAccessible(true);
        assertNotEquals(null, field.get(heroRepository));
    }

    @Test
    public void getCountShouldReturnTheActualSizeOfTheRepository() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(new Hero("Alex", 10, new Item(10, 10, 10)));
        heroRepository.add(new Hero("Alexs", 10, new Item(12, 11, 11)));
        assertEquals(2, heroRepository.getCount());
        ;
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExpectedIfTheHeroAlreadyExists() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(new Hero("Alex", 10, new Item(10, 10, 10)));
        heroRepository.add(new Hero("Alex", 10, new Item(12, 11, 11)));
    }

    @Test
    public void onAddSuccessfullTheSizeShouldBeIncremented() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Alex", 10, new Item(10, 10, 10));
        heroRepository.add(hero);
        assertEquals(1, heroRepository.getCount());
        ;
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExpectedIfTheHeroDoesNotExists() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove("stef");
    }

    @Test
    public void removeShouldDecreaseTheSizeOfTheRepo() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(new Hero("Alex", 10, new Item(10, 10, 10)));
        heroRepository.add(new Hero("Alexs", 10, new Item(12, 11, 11)));
        heroRepository.remove("Alex");
        assertEquals(1, heroRepository.getCount());

    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowExpectedIfThereAreNotSetHeroes() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowExpectedIfThereAreNotHeroesWithSetItem() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(new Hero("Alex", 10, null));
        heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestStrengthShouldReturnTheHeroWhoseItemStrengthIsTheHighest() {
        HeroRepository heroRepository = new HeroRepository();

        Hero hero1 = new Hero("Alex", 10, new Item(10, 10, 10));
        Hero hero2 = new Hero("Ales", 10, new Item(12, 10, 10));
        heroRepository.add(hero1);
        heroRepository.add(hero2);
        assertEquals(hero2, heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowExpectedIfThereAreNotSetHeroes() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.getHeroWithHighestAgility();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowExpectedIfThereAreNotHeroesWithSetItems() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(new Hero("Alex", 10, null));
        heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityShouldReturnTheHeroWhoseItemAgilityIsTheHighest() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("Alex", 10, new Item(10, 14, 10));
        Hero hero2 = new Hero("Ales", 10, new Item(12, 10, 10));
        heroRepository.add(hero1);
        heroRepository.add(hero2);
        assertEquals(hero1, heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowExpectedIfThereAreNotSetHeroes() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.getHeroWithHighestIntelligence();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowExpectedIfThereAreNotHeroesWithSetItem() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(new Hero("Alex", 10, null));
        heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceShouldReturnTheHeroWhoseItemIntelligenceIsTheHighest() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("Alex", 10, new Item(10, 10, 14));
        Hero hero2 = new Hero("Ales", 10, new Item(12, 10, 10));
        heroRepository.add(hero1);
        heroRepository.add(hero2);
        assertEquals(hero1, heroRepository.getHeroWithHighestIntelligence());
    }


    @Test
    public void toStringShouldReturnTheCorrectState() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("Alex", 10, new Item(10, 10, 14));
        assertEquals(String.format("Hero: %s – %d%n" +
                        "  *  Strength: %d%n" +
                        "  *  Agility: %d%n" +
                        "  *  Intelligence: %d%n", "Alex", 10,
                10, 10, 14), hero1.toString());

    }
}