package set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 功能描述：
 * Set集合：
 * 无序存放
 * 元素不重复
 */
public class Demo03 {
    @Test
    public void test01(){
        HashSet<String> set = new HashSet<>();

        set.add("刘备");
        set.add("张飞");
        set.add("关羽");
        set.add("貂蝉");

        //set遍历
        Iterator<String> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        //存储和取出顺序不一致
        System.out.println("----增强循环遍历----");
        for (String s : set) {
            System.out.println(s);
        }
    }

    @Test
    public void test02(){
        HashSet<Person> set = new HashSet<>();
        Person per = new Person(19,"刘备");
        Person per2 = new Person(19,"刘备");
        Person per3 = new Person(22,"张飞");
        set.add(per);
        set.add(per2);//必须重写hashcode和equals，才能实现保证存储的不重复       set.add(per3);
        set.add(per3);
        System.out.println(set);
    }

    /*
    * LinkedHashSet:哈希表+链表
    * 有序
    * 不重复
    */
    @Test
    public void Test03(){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("刘备");
        set.add("张飞");
        set.add("貂蝉");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
