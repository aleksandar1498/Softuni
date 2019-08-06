package p02_ExtendedDatabase;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseExpectedTest {

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExpectedIfInvalidAmountOfValueArePassed() throws OperationNotSupportedException {
        Database database = new Database();
    }
    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExpectedIfTheElementIsNull() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"));
        Person person = null;
        database.add(person);
    }
    @Test
    public void addShouldIncreaseTheCountOfTheElements() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"));
        database.add(new Person(2,"Sash"));
        assertEquals(2,database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExpectedIfTheDatabaseIsEmpty() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"));
        database.remove();
        database.remove();
    }
    @Test
    public void removeShouldDecreaseTheCountOfTheElements() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"));
        database.remove();
        assertEquals(0,database.getElements().length);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExpectedIfAUserWithSpecifiedUsernameDoesNotExists() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"));
        database.findByUsername("Alex");

    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExpectedIfTheUsernamePassedAsArgumentIsNull() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"));
        String name = null;
        database.findByUsername(name);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExpectedIfThereAreMorePeopleWithTheSameId() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"),new Person(1,"Alexs"));
        database.findById(1);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExpectedIfThereIsNoResult() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alex"),new Person(1,"Alexs"));
        database.findById(4);
    }
    @Test
    public void findByIdShouldReturnTheCorrectUser() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Alexs"));
        Person person = new Person(2,"Alexs");
        database.add(person);
        Person actual = database.findById(2);
        assertEquals(person,actual);
    }


}