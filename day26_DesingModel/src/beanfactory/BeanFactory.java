package beanfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射工厂实现:
 * 设置传入的参数为需要创建的对象类型全限定名和对象类型字节码来创建对象
 */
public class BeanFactory {

    //反射工厂方法:通过传入的参数得到对象，可以适用任意对象创建
    public static <T> T newInstance(String classname,Class<T> type){
        try {
            Class<?> aClass = Class.forName(classname);
            Constructor constructor = aClass.getConstructor();
            Object o = constructor.newInstance();

            //判断是否是指定类型，如果是则转换类型
            //type.isInstance(o): o是type字节码文件的对象
            if(type.isInstance(o)){
                return (T)o;
            }else{//不是当前类型对象抛异常
                throw new RuntimeException("当前对象与类型不兼容");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
