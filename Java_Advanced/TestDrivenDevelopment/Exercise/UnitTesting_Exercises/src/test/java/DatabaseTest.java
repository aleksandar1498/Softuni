

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseTest {


    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExpectedIfTheElementIsNull() throws OperationNotSupportedException {
        Database database  = new Database(this.createElements(15).toArray(Integer[]::new));
        Integer val = null;
        database.add(val);
    }
    @Test
    public void addShouldIncreaseTheElementCount() throws OperationNotSupportedException {
        Database database  = new Database(this.createElements(15).toArray(Integer[]::new));
        database.add(12);
        Integer[] integers = database.getElements();
        Assert.assertEquals(Integer.valueOf(12),database.getElements()[15]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExpectedIfTheIndexIsPointingOutOfTheArray() throws OperationNotSupportedException {
        Database database  = new Database(this.createElements(1).toArray(Integer[]::new));
        database.remove();
        database.remove();
    }
    @Test
    public void removeShouldSetTheCurrentPointingIndexToNull() throws OperationNotSupportedException {
        Database database  = new Database(this.createElements(1).toArray(Integer[]::new));
        database.remove();
        Integer [] expected = new Integer[0];
        Integer [] actual = database.getElements();
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void getElementsShouldReturnAllTheElementsSetInTheArray() throws OperationNotSupportedException {
        Database database = new Database(this.createElements(1).toArray(Integer[]::new));
        database.remove();
        database.add(10);
        database.add(12);
        Integer [] expected = new Integer[]{10,12};
        Integer [] actual = database.getElements();
        Assert.assertArrayEquals(expected,actual);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void setElementsShouldThrowExpectedIfTheSizeOfTheElementsIsLessThanOne() throws OperationNotSupportedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Database database = new Database(this.createElements(1).toArray(Integer[]::new));

        Method method = Class.forName("p01_Database.Database").getDeclaredMethod("setElements",Integer[].class);
        method.setAccessible(true);
        try {
            method.invoke(database, (Object) new Integer[]{});
        }catch (InvocationTargetException ex){
            throw new OperationNotSupportedException();
        }

    }
    @Test(expected = OperationNotSupportedException.class)
    public void setElementsShouldThrowExpectedIfTheSizeOfTheElementsIsMoreThan16() throws OperationNotSupportedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Database database = new Database(this.createElements(1).toArray(Integer[]::new));

        Method method = Class.forName("p01_Database.Database").getDeclaredMethod("setElements",Integer[].class);
        method.setAccessible(true);
        try {
            method.invoke(database, (Object) this.createElements(17).toArray(Integer[]::new));
        }catch (InvocationTargetException ex){
            throw new OperationNotSupportedException();
        }

    }
    @Test
    public void fetchShouldReturnCorrectType() throws OperationNotSupportedException, ClassNotFoundException, NoSuchMethodException {
        Database database = new Database(this.createElements(1).toArray(Integer[]::new));
        Method method = Class.forName("p01_Database.Database").getDeclaredMethod("getElements",null);
        Assert.assertEquals(Integer[].class,method.getReturnType());
    }
    private List<Integer> createElements(int count){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(null);
        }
        return list;
    }

}
