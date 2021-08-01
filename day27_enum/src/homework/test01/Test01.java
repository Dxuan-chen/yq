package homework.test01;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 功能描述：
 * 定义一个Person类，其中包含姓名，年龄，生日，性别，其中性别只能是“男”或“女”(用枚举实现)
 */
public class Test01 {
    public static void main(String[] args) throws ParseException {
        Person person = new Person("晓晓",23,new SimpleDateFormat("yyyy-MM-dd").parse("1999-5-5"),Sex.FEMALE);
        System.out.println(person);
    }
}
