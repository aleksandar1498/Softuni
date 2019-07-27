import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class ListyIteratorTests {
    public static final String [] BASE_LIST_TO_ITERATE= {"A","B","C"};

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExpectedExceptionIfNullArgumentIsPassed() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }
    @Test
    public void moveShouldReturnFalseIfTheCurrentIndexIsPointingAtTheEnd() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(BASE_LIST_TO_ITERATE);
        listIterator.move();
        listIterator.move();
        boolean result = listIterator.move();
        assertEquals(false,result);
    }
    @Test
    public void moveShouldReturnTrueIfTheCurrentIndexIsNotPointingAtTheEnd() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(BASE_LIST_TO_ITERATE);
        listIterator.move();
        boolean result = listIterator.move();
        assertEquals(true,result);
    }

    @Test
    public void hasNextShouldReturnFalseIfTheCurrentPointingIndexIsTheLast() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(BASE_LIST_TO_ITERATE);
        listIterator.move();
        listIterator.move();
        boolean result = listIterator.hasNext();
        assertEquals(false,result);
    }
    @Test
    public void hasNextShouldReturnTrueIfTheCurrentPointingIndexIsNotTheLast() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(BASE_LIST_TO_ITERATE);
        listIterator.move();
        boolean result = listIterator.hasNext();
        assertEquals(true,result);
    }
    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExpectedIfThereAreNotElements() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        System.out.println(listIterator.print());
    }
    @Test
    public void printShouldReturnTheValueAtTheCurrentIndex() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(BASE_LIST_TO_ITERATE);
        assertEquals("A",listIterator.print());
    }
}
