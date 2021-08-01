package homework.test10;

import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test10 {
    public static void main(String[] args) {
        Class<Transfer> tClass = Transfer.class;
        Method[] methods = tClass.getDeclaredMethods();
        for (Method method : methods) {
//            method.setAccessible(true);
            if (method.isAnnotationPresent(LogInfo.class)) {
                LogInfo lonInfo = method.getAnnotation(LogInfo.class);
                System.out.println("value:"+lonInfo.value());
                System.out.println("userName:"+lonInfo.userName());
                System.out.println("date:"+lonInfo.date());
            }
        }
    }
}
