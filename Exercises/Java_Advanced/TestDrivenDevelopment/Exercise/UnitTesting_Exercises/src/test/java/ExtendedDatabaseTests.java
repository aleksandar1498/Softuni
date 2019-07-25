import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;
import static p02_ExtendedDatabase.Person.DEFAULT_ID;

public class ExtendedDatabaseTests {

    private static final Person[] BASIC_LIST = new Person[]{
            new Person(1, "Alex"),
            new Person(1, "Alex"),
            new Person(2, "Goshko"),
            new Person(3, "Stivan")
    };

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExpectedIfThereArePeopleWithSameId() throws OperationNotSupportedException {
        Database database = new Database(BASIC_LIST);
        database.findById(DEFAULT_ID);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExpectedIfThereArePeopleWithNegativeId() throws OperationNotSupportedException {
        Database database = new Database(BASIC_LIST);
        database.findById(-DEFAULT_ID);
    }
    @Test
    public void removeShouldDeleteTheLastInsertedPersonInTheArray() throws OperationNotSupportedException {
        Database database = new Database(BASIC_LIST);
        database.remove();
        assertEquals(BASIC_LIST.length-1,database.getElements().length);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameShouldThrowExpectedIfThereAreNotMatches() throws OperationNotSupportedException {
        Database database = new Database(BASIC_LIST);
        database.findByUsername("DEFAULT_ID");
    }
    @Test
    public void findUsernameReturnsCorrectPerson() throws OperationNotSupportedException {
        Database database = new Database(BASIC_LIST);
        Person person = database.findByUsername("Goshko");
        assertEquals(BASIC_LIST[2],person);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameShouldThrowExpecteWhenPassedUsernameIsNull() throws OperationNotSupportedException {
        Database database = new Database(BASIC_LIST);
        database.findByUsername(null);
    }
}
