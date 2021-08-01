package collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Collections接口定义了集合常用功能：
 * 打乱 shuffle(集合)
 * 排序
 * 添加多个元素到集合  addAll(集合,元素...)
 */
public class Demo05 {

    @Test
    public void test01(){
        ArrayList<String> strs = new ArrayList<>();

        Collections.addAll(strs,"刘备","张飞","貂蝉");
        System.out.println(strs);
        Collections.shuffle(strs);
        System.out.println(strs);

        //默认规则排序
        Collections.addAll(strs,"c","d","a");
        Collections.sort(strs);
        System.out.println(strs);
    }

    /*
    * sort排序：
    * 1.类有实现比较接口Comparable   定义类排序默认规则，比较死
    * 2.继承Comparator比较器 接口      灵活定义排序规则
    */
    @Test
    public void test02(){
        Person person = new Person(19, "刘备");
        Person person2 = new Person(18, "张飞");
        Person person3 = new Person(29, "关羽");
        Person person4 = new Person(22, "貂蝉");
        ArrayList<Person> people = new ArrayList<>();
        Collections.addAll(people,person,person2,person3,person4);
        System.out.println(people);
        //排序
        Collections.sort(people);
        System.out.println(people);
    }

    //根据字符串z y x ...降序排序
    @Test
    public void test03(){
        ArrayList<String> strs = new ArrayList<>();
        Collections.addAll(strs,"c","d","a");
        System.out.println(strs);
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //o1.charAt(0):获取第一个字符  整数
                return o1.charAt(0)-o2.charAt(0);
            }
        });
        System.out.println(strs);
    }

}
