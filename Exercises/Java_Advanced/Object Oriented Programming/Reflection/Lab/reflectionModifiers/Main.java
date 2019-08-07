import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> reflectionClass = Reflection.class;
        Reflection reflection = reflectionClass.getConstructor().newInstance();
        Field [] fields = Arrays.stream(reflectionClass.getDeclaredFields()).filter(field -> !Modifier.isPrivate(field.getModifiers())).sorted(Comparator.comparing(Field::getName)).toArray(Field[]::new);
        Method[] methods  = reflectionClass.getDeclaredMethods();
        Method[] getters = Arrays.stream(methods).filter(get -> get.getName().startsWith("get") && get.getParameterCount() == 0 && !Modifier.isPublic(get.getModifiers())).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        Method [] setters = Arrays.stream(methods).filter(get -> get.getName().startsWith("set") && get.getParameterCount() == 1 && !Modifier.isPrivate(get.getModifiers())).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        Arrays.stream(fields).forEach(f -> System.out.printf("%s must be private!%n",f.getName()));
        Arrays.stream(getters).forEach(g -> System.out.printf("%s have to be public!%n",g.getName()));
        Arrays.stream(setters).forEach(s -> System.out.printf("%s have to be private!%n",s.getName()));

    }
}
