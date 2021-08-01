package homework.test04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class TestA {
    public static void main(String[] args) {
        try {
            System.out.println("请输入：");
            String input = new Scanner(System.in).nextLine();
            Class<TestShow> tClass = (Class<TestShow>) Class.forName(input);
            TestShow testShow = tClass.newInstance();

            Method method = tClass.getDeclaredMethod("showString",String.class);
            method.setAccessible(true);//设置可访问
            method.invoke(testShow,"showString方法执行了...");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
