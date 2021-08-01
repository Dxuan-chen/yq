package homework.test02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        Student stu1 = new Student("小明",22,"男");
        Student stu2 = new Student("小红",20,"女");
        Student stu3 = new Student("小黑",21,"男");
        FileOutputStream fos = new FileOutputStream("stu.txt");
        ObjectOutputStream stream = new ObjectOutputStream(fos);
        List<Student> list = new ArrayList<>();
        Collections.addAll(list,stu1,stu2,stu3);
        stream.writeObject(list);
        stream.close();
        fos.close();
    }
}
