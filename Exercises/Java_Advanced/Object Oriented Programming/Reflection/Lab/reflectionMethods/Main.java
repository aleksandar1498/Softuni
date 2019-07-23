package reflectionMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method [] methods = Reflection.class.getDeclaredMethods();
        Method [] getters = Arrays.stream(methods).filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        Method [] setters = Arrays.stream(methods).filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
Arrays.stream(getters).forEach(getter -> {
        System.out.printf("%s will return class %s%n",getter.getName(),getter.getReturnType().getName());
    });
        Arrays.stream(setters).sorted(Comparator.comparing(Method::getName)).forEach(setter -> {
            System.out.printf("%s and will set field of class %s%n",setter.getName(),setter.getParameterTypes()[0].getName());
        });


    }
}
