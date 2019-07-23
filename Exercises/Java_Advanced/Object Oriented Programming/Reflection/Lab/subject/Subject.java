package annotations.subject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//target defines that on what this annotation can be placed
// retention is used to where the annotation is visible
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Subject {
    String[] categories();
}
