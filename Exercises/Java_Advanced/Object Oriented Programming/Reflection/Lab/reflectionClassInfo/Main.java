

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class reflection = Reflection.class;
        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());
        for (Class reflectionInterface : reflection.getInterfaces()) {
            System.out.println(reflectionInterface);
        }
        Reflection reflectionInstance = (Reflection) reflection.getConstructor().newInstance();
        System.out.println(reflectionInstance);
    }
}
