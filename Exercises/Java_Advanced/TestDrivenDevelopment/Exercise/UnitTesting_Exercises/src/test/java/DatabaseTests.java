import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class DatabaseTests {
    private final Integer[] BASE_VALUES = new Integer[]{1, 2, 3, 4, 5};
    private Class<?> databaseClass;
    private Database database;


    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowOperationNotSupportedExceptionIfBufferSizeIsNot16Integers() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, OperationNotSupportedException {

        Database database = new Database(new Integer[20]);


    }

    @Test
    public void constructorShouldStoreTheElementsOnceCalled() throws NoSuchMethodException, IllegalAccessException, OperationNotSupportedException, InstantiationException, InvocationTargetException {
        Database database = new Database(new Integer[1]);
        assertEquals(1, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowOperationNotSupportedExceptionIfElementIsNull() throws NoSuchMethodException, IllegalAccessException, OperationNotSupportedException, InstantiationException, InvocationTargetException {
        Database database = new Database(BASE_VALUES);
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowOperationNotSupportedExceptionIfDatabaseIsEmpty() throws NoSuchMethodException, IllegalAccessException, OperationNotSupportedException, InstantiationException, InvocationTargetException {
        Database database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }
    @Test
    public void fetchMethodShouldReturnTheElementsAsArray() throws OperationNotSupportedException, NoSuchMethodException {
        Database database = new Database(BASE_VALUES);
        Method method  = database.getClass().getDeclaredMethod("getElements");
        assertEquals(Integer[].class,method.getReturnType());
    }
}
