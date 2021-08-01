package homework.test10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LogInfo {
    String value();
    String userName() default "";
    String date() ;
}
