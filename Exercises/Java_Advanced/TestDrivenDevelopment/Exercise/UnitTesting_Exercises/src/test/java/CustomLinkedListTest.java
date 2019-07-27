import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomLinkedListTest {
    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExpectedExceptionIfTheIndexIsNegative(){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        customLinkedList.add(12);
        customLinkedList.get(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExpectedExceptionIfTheIndexIsMoreOrEqualOfTheListLength(){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        customLinkedList.add(12);
        customLinkedList.get(4);
    }
    @Test
    public void getShouldReturnTheCorrectElementAtTheGivenIndex(){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        customLinkedList.add(12);

        assertEquals(12,customLinkedList.get(1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExpectedExceptionIfTheIndexIsNegative(){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        customLinkedList.add(12);
        customLinkedList.set(-1,10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExpectedExceptionIfTheIndexIsMoreOrEqualOfTheListLength(){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        customLinkedList.add(12);
        customLinkedList.set(4,10);
    }
    @Test
    public void setShouldChangeTheValueAtGivenIndex(){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        customLinkedList.add(12);
        customLinkedList.set(1,14);
        assertEquals(14,customLinkedList.get(1));
    }
    @Test
    public void addOnAnEmptyLinkedListShouldBringToEqualTailAndHead() throws NoSuchFieldException, IllegalAccessException {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(10);
        Field tail = customLinkedList.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        Field head = customLinkedList.getClass().getDeclaredField("head");
        head.setAccessible(true);
        boolean areEquals = tail.get(customLinkedList) == head.get(customLinkedList);
        assertTrue(areEquals);
    }



}
