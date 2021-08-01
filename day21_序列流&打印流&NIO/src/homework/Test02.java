package homework;

import homework.test02.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/13
 */
public class Test02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("stu.txt");
        ObjectInputStream stream = new ObjectInputStream(fis);
        List<Student> list = (List<Student>)stream.readObject();
        stream.close();
        fis.close();
        System.out.println(list);
    }
}
