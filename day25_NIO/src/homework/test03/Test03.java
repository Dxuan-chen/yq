package homework.test03;

import homework.test03.Show03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Test03 {
    public static void main(String[] args) {
        try {
            Show03 show03 = new Show03();
            Class<Show03> sClass = (Class<Show03>)show03.getClass();
            Method method = sClass.getMethod("show",String.class);
            method.invoke(show03,"show方法执行了...");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
