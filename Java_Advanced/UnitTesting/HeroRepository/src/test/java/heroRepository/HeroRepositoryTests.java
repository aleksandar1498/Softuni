package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    HeroRepository heroRepository;

    @Before
    public void init() {
        this.heroRepository = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void createShouldThrowExpectedIfNull() {
        Hero invalidHero = null;
        this.heroRepository.create(invalidHero);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createShouldThrowExpectedIfAHeroWithThatNameExists() {
        this.heroRepository.create(new Hero("alex",2));
        this.heroRepository.create(new Hero("alex",2));
    }

    @Test
    public void createShouldIncreaseTheSizeOfHeroRepositoryStructureData(){
        Hero hero = new Hero("Alex",2);
        this.heroRepository.create(hero);
        Assert.assertEquals(1,heroRepository.getCount());
    }

    @Test
    public void createShouldReturnSuccessMessageWhenHeroIsAddedToTheRepository(){
        Hero hero = new Hero("Alex",2);
        Assert.assertEquals(true,String.format("Successfully added hero Alex with level 2").equals(this.heroRepository.create(hero)));
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExpectedIfTheArgumentIsEmpty(){
        String invalidArgument = "";
        this.heroRepository.remove(invalidArgument);
    }
    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExpectedIfTheArgumentIsNull(){
        String invalidArgument = null;
        this.heroRepository.remove(invalidArgument);
    }
    @Test
    public void removeShouldReturnFalseIfTheHeroIsNotFound(){
        Assert.assertFalse(this.heroRepository.remove("Alss"));
    }
    @Test
    public void removeShouldReturnTrueIfTheHeroFoundAndRemoved(){
        this.heroRepository.create(new Hero("Alex",2));
        Assert.assertTrue(this.heroRepository.remove("Alex"));
    }
    @Test
    public void getHeroWithHighestLevelShouldReturnNullIfTheRepoIsEmpty(){
        Assert.assertNull(this.heroRepository.getHeroWithHighestLevel());
    }
    @Test
    public void getHeroWithHighestLevelShouldReturnTheCorrectHero(){
        Hero expected = new Hero("C",3);
        this.heroRepository.create(new Hero("A",1));
        this.heroRepository.create(new Hero("B",2));
        this.heroRepository.create(expected);
        Assert.assertEquals(expected,this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void getHeroShouldReturnNullIfTheHeroWithThatNameIsNotPresent(){
        Assert.assertNull(this.heroRepository.getHero("Alex"));
    }
    @Test
    public void getHeroShouldReturnTheExpectedHeroByHisName(){
        Hero expected = new Hero("C",3);
        this.heroRepository.create(expected);
        Assert.assertEquals(expected,this.heroRepository.getHero("C"));
    }

}
