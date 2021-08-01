package annotation;

import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target(value = {ElementType.METHOD,ElementType.CONSTRUCTOR})
//@Retention()
public @interface BookInfo {
    String[] author() default {};
    String[] name() default "";
    String value() default "";
}
