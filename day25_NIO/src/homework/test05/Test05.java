package homework.test05;

import java.lang.reflect.Field;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Test05 {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj.getPropertyName());
        Test05 test05 = new Test05();
        test05.setProperty(obj,"propertyName",new java.lang.Object());
        System.out.println("setProperty:"+obj);
        System.out.println("getProperty:"+test05.getProperty(obj,"propertyName"));
    }

    public void setProperty(Object obj, String propertyName, java.lang.Object value){
        Class<?> oClass = obj.getClass();
        try {
            Field field = oClass.getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(obj,value);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public java.lang.Object getProperty(Object obj, String propertyName){
        Class oClass = obj.getClass();
        Field field2 = null;
        java.lang.Object o = null;
        try {
            field2 = oClass.getDeclaredField(propertyName);
            field2.setAccessible(true);
            o = field2.get(obj);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return o;
    }


}
