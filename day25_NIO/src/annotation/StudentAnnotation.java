package annotation;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public @interface StudentAnnotation {
    String name();
    int age() default 10;
    String value();
}
