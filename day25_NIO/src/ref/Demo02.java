package ref;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Demo02 {
    public static void main(String[] args) {
        Student student = createInstance();
        System.out.println(student);
    }

    /*
    * 读取配置文件，获取属性信息
    * 根据属性信息反射创建对象
    * 遍历其他属性信息，反射给对象属性赋值
    * 返回对象
    */

    public static Student createInstance() {
        Properties props = new Properties();
        Student student = null;
        try {
            props.load(new InputStreamReader(new FileInputStream("day25_NIO/src/stu.properties"),"UTF-8"));
            String classProperty = props.getProperty("class");
            Class<Student> aClass = (Class<Student>) Class.forName(classProperty);
            student = aClass.newInstance();
            //获取所有的属性key
            Set<String> names = props.stringPropertyNames();
            for (String name : names) {
                if("class".equals(name)){
                    continue;
                }
                //反射获取属性
                Field field = aClass.getDeclaredField(name);
                //设置暴力破解
                field.setAccessible(true);
                //获取属性
                String value = props.getProperty(name);
                Class<?> type = field.getType();
                System.out.println("type:"+type);
                //设置属性值
                if("int".equals(field.getType()+"")){//field.getType() instanceof int.class
                    field.set(student,Integer.parseInt(value));
                }else {
                    field.set(student,value);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        return student;
    }
}
