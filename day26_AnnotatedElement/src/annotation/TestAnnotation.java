package annotation;

import com.sun.jdi.ArrayReference;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {
        //1.反射获取类 和 方法对象
        Class<TestComputer> clazz = TestComputer.class;
        Method method = clazz.getDeclaredMethod("show");

        //2.获取类上的注解
        if(clazz.isAnnotationPresent(Computer.class)){//clazz类里有用Computer注解
            Computer computer = clazz.getAnnotation(Computer.class);
            System.out.println("类上的注解属性：");
            System.out.println(computer.price());
            System.out.println(computer.value());
            System.out.println(Arrays.toString(computer.factories()));
        }

        //3.获取方法上的注解
        if (method.isAnnotationPresent(Computer.class)) {
            Computer computer = method.getAnnotation(Computer.class);
            System.out.println("方法上的注解属性：");
            System.out.println(computer.price());
            System.out.println(computer.value());
            System.out.println(Arrays.toString(computer.factories()));
        }
    }
}
