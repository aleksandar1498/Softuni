package annotations.codingTracker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Tracker {
    @Author(name = "Aleksandar")
    public static  void printMethodsByAuthor(Class<?> clazz){
        Method [] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(Author.class);
            if(annotation != null){
                System.out.println(((Author) annotation).name()+": "+method.getName()+"()");
            }
        }
    }
}
