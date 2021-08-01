package homework.test06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Test06 {
    public static void main(String[] args) {
        Class<Person> pClass = (Class<Person>) Person.class;
        try {
            Person person = (Person) pClass.newInstance();
            Method method = pClass.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);
            method.invoke(person,"李四");
            Method method2 = pClass.getDeclaredMethod("setAge", int.class);
            method2.setAccessible(true);
            method2.invoke(person,22);
            System.out.println(person);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        try {
//            Constructor constructor = pClass.getDeclaredConstructor(String.class,int.class);
//            Person person = (Person) constructor.newInstance("张三",21);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


    }
}
