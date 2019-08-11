package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExpectedIfTheNameIsNull() {
        String name =null;
      Spaceship spaceship=new Spaceship(name,10);
    }
    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExpectedIfTheNameIsEmtpy() {
        String name ="   ";
        Spaceship spaceship=new Spaceship(name,10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExpectedIfCapacityIsLessThanZero() {
        String name ="alex";
        Spaceship spaceship=new Spaceship(name,-2);
    }
    @Test
    public void getNameShouldRetrieveTheCorrectName(){
        Spaceship spaceship=new Spaceship("Alex",10);
        Assert.assertEquals("Alex",spaceship.getName());
    }
    @Test
    public void getCapacityShouldRetrieveTheCorrectCapacity(){
        Spaceship spaceship=new Spaceship("Alex",10);
        Assert.assertEquals(10,spaceship.getCapacity());
    }
    @Test
    public void getCountShouldReturnZeroIfThereAreNotAstronauts(){
        Spaceship spaceship = new Spaceship("Alex",10);
        Assert.assertEquals(0,spaceship.getCount());
    }
    @Test
    public void getCountShouldReturnCorrectWhenAstronautsAreSet(){
        Spaceship spaceship = new Spaceship("Alex",10);
        spaceship.add(new Astronaut("alex",10));
        Assert.assertEquals(1,spaceship.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExpectedIfTheSizeIsAchieved(){
        Spaceship spaceship = new Spaceship("S",1);
        spaceship.add(new Astronaut("alex",10));
        spaceship.add(new Astronaut("alsex",10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExpectedIfTheAnastronautWithThatNameExists(){
        Spaceship spaceship = new Spaceship("S",2);
        spaceship.add(new Astronaut("alex",10));
        spaceship.add(new Astronaut("alex",10));
    }
    @Test
    public void removeShouldReturnFalseIfTheAstronautNameDoesNotExist(){
        Spaceship spaceship = new Spaceship("S",2);
        Assert.assertFalse(spaceship.remove("sada"));
    }
    @Test
    public void removeShouldReturnTrueIfTheAstronautNameExists(){
        Spaceship spaceship = new Spaceship("S",2);
        spaceship.add(new Astronaut("alex",10));
        Assert.assertTrue(spaceship.remove("alex"));
    }

}
