import org.junit.Test;
import p04_BubbleSortTest.Bubble;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {
    @Test
    public void sortShouldReturnAnOrderedArray(){
        int [] arr = new int[]{1,3,-2,5,6,4};
        int [] sorted = new int[]{-2,1,3,4,5,6};
        Bubble.sort(arr);
        assertArrayEquals(sorted,arr);
    }
}
