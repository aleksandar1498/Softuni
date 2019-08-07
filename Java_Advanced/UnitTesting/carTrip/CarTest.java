package carTrip;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowExpectedIfTheModelIsNull() {
        String model = null;
        Car car = new Car(model, 20.0, 20.0, 30.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowExpectedIfTheModelIsEmpty() {
        Car car = new Car("", 20.0, 20.0, 30.0);
    }

    @Test
    public void setModelShouldChangeTheValueOfTheModel() {
        Car car = new Car("Sas", 20.0, 20.0, 30.0);
        car.setModel("Ves");
        assertEquals("Ves", car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldThrowExpectedIfItIsMoreThanTheTankCapacity() {
        Car car = new Car("Sas", 20.0, 10.0, 30.0);
        car.setFuelAmount(32);
    }

    @Test
    public void setFuelAmountShouldChangeTheValueOfTheCurrentAmount() {
        Car car = new Car("Sas", 20.0, 10.0, 30.0);
        car.setFuelAmount(8.0);
        assertEquals(0, Double.compare(8.0, car.getFuelAmount()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmShouldThrowExpectedIfTheValueIsLessOrEqualThenZero() {
        new Car("Sas", 20.0, 10.0, -1.0);
    }

    @Test
    public void setFuelConsumptionPerKmShouldChangeTheValueOfTheCurrentConsumption() {
        Car car = new Car("Sas", 20.0, 10.0, 30.0);
        car.setFuelConsumptionPerKm(8.0);
        assertEquals(0, Double.compare(8.0, car.getFuelConsumptionPerKm()));
    }

    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowExpectedIfCurrentAmountOfFuelIsLessThenTheNeededByTheTrip() {
        Car car = new Car("Sas", 20.0, 10.0, 30.0);
        car.drive(20);
    }

    @Test
    public void driveShouldReduceTheAmountOfCurrentFuelOnSuccess() {
        Car car = new Car("Sas", 120.0, 100.0, 10.0);
        car.drive(1);
        assertEquals(0, Double.compare(90, car.getFuelAmount()));
    }

    @Test
    public void driveShouldReturnConfirmOnSuccess() {
        Car car = new Car("Sas", 120.0, 100.0, 10.0);
        String response = car.drive(1);
        assertEquals("Have a nice trip", response);
    }

    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrowExpectedIfTheNewAmountIsMoreThanTheTotCapacity() {
        Car car = new Car("Sas", 120.0, 100.0, 10.0);
        car.refuel(30);
    }
    @Test
    public void refuelShouldIncreaseTheCurrentAmountOfFuelOnSuccess() {
        Car car = new Car("Sas", 120.0, 100.0, 10.0);
        car.refuel(10);
        assertEquals(0,Double.compare(110,car.getFuelAmount()));
    }
    


}