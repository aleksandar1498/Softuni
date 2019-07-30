import exceptionHandling.Person;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class PersonTest {
    @Test
    public void personShouldBeValid(){
        Person person  = new Person("Alex","Stef",20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void emptyPersonShouldThrowExpected(){
        Person person  = new Person("","Stef",20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nullLastNameShouldThrowExpected(){
        Person person  = new Person(null,"Stef",20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void negativeAgeShouldThrowExpected(){
        Person person  = new Person("Alex","Stef",-20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ageMoreThan120ShouldThrowExpected(){
        Person person  = new Person("Alex","Stef",122);
    }
}
