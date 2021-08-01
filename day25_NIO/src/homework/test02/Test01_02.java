package homework.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Test01_02 {
    public static void main(String[] args) {
        try {
            Class<Student> sClass = (Class<Student>) Class.forName("homework.test02.Student");
            Constructor<Student> constructor = sClass.getConstructor(String.class,int.class);
            Student student = constructor.newInstance("张三",22);
            System.out.println(student);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
