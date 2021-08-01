package homework.test04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/13
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList<>();
        Collections.addAll(list,
                new Student("小明",22,"男"),
                new Student("小红",20,"女"),
                new Student("小黑",21,"男"));
        FileOutputStream fos = new FileOutputStream("stus.txt");
        ObjectOutputStream stream = new ObjectOutputStream(fos);
        stream.writeObject(list);
        stream.close();
        fos.close();
    }
}
