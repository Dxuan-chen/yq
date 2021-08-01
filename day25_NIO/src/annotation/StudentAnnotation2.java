package annotation;

public @interface StudentAnnotation2 {
    String name() default "";
    int age() default 10;
    String value();
}
