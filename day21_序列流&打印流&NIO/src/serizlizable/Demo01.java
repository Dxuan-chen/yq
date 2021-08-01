package serizlizable;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/13
 */
public class Demo01 {

    //序列化
    @Test
    public void test01() throws IOException {
        Person person = new Person(1001,"小明",23);

        FileOutputStream fos = new FileOutputStream("person.txt");

        ObjectOutputStream stream = new ObjectOutputStream(fos);

        stream.writeObject(person);
        stream.close();
    }

    //反序列化
    //java.io.EOFException:读到文件末尾，无法完整读取对象信息
    @Test
    public void test02() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("person.txt");
        ObjectInputStream stream = new ObjectInputStream(fis);
        Person object = (Person)stream.readObject();
        System.out.println(object);
        stream.close();
        fis.close();
    }

    //将存有多个自定义对象的集合序列化操作，保存到list.txt文件中。
    //反序列化list.txt，并遍历集合，打印对象信息。
    @Test
    public void test03() throws IOException {
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,new Person(1001,"小明",23),new Person(100,"小红",22));
        FileOutputStream fos = new FileOutputStream("person.txt");
        ObjectOutputStream stream = new ObjectOutputStream(fos);
        stream.writeObject(list);
        stream.close();
        fos.close();

    }

    //反序列化对象集合
    @Test
    public void test04() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("person.txt");
        ObjectInputStream stream = new ObjectInputStream(fis);
        //如果存入和取出不是List操作，而是逐个person存取 那么在遍历取的时候，会导致EOFException取出的判断条件无法判断读取完毕
        List<Person> list = (List<Person>) stream.readObject();
        System.out.println(list);

    }
}
