package unitTesting;


import org.junit.Assert;
import org.junit.Test;

public class RaceEntryTest {
    //
    @Test(expected = NullPointerException.class)
    public void addRiderShouldThrowExpectedIfTheRiderIsNull() {
        RaceEntry raceEntry = new RaceEntry();
        UnitRider rider = null;
        raceEntry.addRider(rider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShouldReturnExpectedIfTheRiderAlreadyExists() {
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(new UnitRider("Alex", new UnitMotorcycle("BMW", 10, 23.2)));
        raceEntry.addRider(new UnitRider("Alex", new UnitMotorcycle("BMW", 10, 23.2)));

    }
    @Test
    public void addRiderSuccessfulShouldIncreaseTheSizeOfTheInnerCollection(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(new UnitRider("Alex", new UnitMotorcycle("BMW", 10, 23.2)));
        Assert.assertEquals(1,raceEntry.getRiders().size());
    }
    @Test
    public void addRiderSuccessfulShouldReturnMessage(){
        RaceEntry raceEntry = new RaceEntry();
        String message = raceEntry.addRider(new UnitRider("Alex", new UnitMotorcycle("BMW", 10, 23.2)));
        Assert.assertEquals("Rider Alex added in race.",message);
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExpectedIfTheCurrentNumberOfUsersIsLessThenMin(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.calculateAverageHorsePower();
    }
    @Test
    public void calculateAverageHorsePowerShouldReturnTheCorrectAverage(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(new UnitRider("Alex", new UnitMotorcycle("BMW", 10, 23.2)));
        raceEntry.addRider(new UnitRider("Alexs", new UnitMotorcycle("BM2W", 10, 23.2)));
        raceEntry.addRider(new UnitRider("Alex2", new UnitMotorcycle("BM2W", 10, 23.2)));

        Assert.assertEquals(0, Double.compare(10.00, raceEntry.calculateAverageHorsePower()));
    }
    @Test(expected =  UnsupportedOperationException.class)
    public void getRidersShouldThrowExpectedWhenWeTryToPerformAnyOperationOnIt(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(new UnitRider("Alex", new UnitMotorcycle("BMW", 10, 23.2)));
        raceEntry.addRider(new UnitRider("Alexs", new UnitMotorcycle("BM2W", 10, 23.2)));
        raceEntry.addRider(new UnitRider("Alex2", new UnitMotorcycle("BM2W", 10, 23.2)));
        raceEntry.getRiders().add(new UnitRider("Alex2s", new UnitMotorcycle("BM2W", 10, 23.2)));

    }
}
