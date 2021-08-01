package homework.test09;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test09 {
    public static void main(String[] args) {
        Class<TestMethods> tClass = TestMethods.class;
        try {
            TestMethods testMethods = tClass.newInstance();
            Method[] methods = tClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyTest.class)) {
                    method.invoke(testMethods);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
