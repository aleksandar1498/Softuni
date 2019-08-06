package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void checkShouldActivateTheAlarmWhenTheSensorValueIsLessThanTheLowPressureThreshold() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(14.00);
        Alarm alarm = new Alarm();
        Field sensorField = alarm.getClass().getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(alarm,sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void checkShouldActivateTheAlarmWhenTheSensorValueIsHigherThanTheLowPressureThreshold() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(26.00);
        Alarm alarm = new Alarm();
        Field sensorField = alarm.getClass().getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(alarm,sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());

    }
    @Test
    public void checkShouldNotActivateTheAlarmWhenTheSensorValueHasNormalValue() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor= Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.00);
        Alarm alarm = new Alarm();
        Field sensorField = alarm.getClass().getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(alarm,sensor);
        alarm.check();
        assertFalse(alarm.getAlarmOn());

    }


    @Test
    public void getAlarmOnShouldReturnBoolean() throws NoSuchMethodException {
        Alarm alarm = new Alarm();
        Class<?> getAlarmOnReturnType = alarm.getClass().getDeclaredMethod("getAlarmOn", null).getReturnType();
        assertEquals(boolean.class,getAlarmOnReturnType);
    }
}