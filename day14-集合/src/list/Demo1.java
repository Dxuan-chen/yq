package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/2
 */

public class Demo1 {

    @Test
    public void test01(){
        //1.有序集合
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("c");
        strings.add("b");
        for(String string : strings){
            System.out.println(string);
        }

        //2.由于数据结构是数组，可以通过索引来快速查找元素
        System.out.println(strings.get(0));

        //3.元素可以重复,通过equals方法判断是否重复
        strings.add("a");
        strings.add("c");
        strings.add("b");
        System.out.println(strings);

        //List常用api：set(索引，新元素)
        strings.set(5,"a");
        System.out.println(strings);
        //add(索引，新元素)
        strings.add(3,"中");
        System.out.println(strings);
    }

    /**
     * 它是基于数组实现的List子类
     * 动态调整容量
     * 有序
     * 元素可以为null
     * 不同步，非线程安全，效率高（比Vector）
    */

    @Test
    public void test02(){
        /*
        *创建后，还没有赋值的时候，维护的是一个空数组，当第一次插入数据的时候，才会创建出一个初始容量为10的数组
        */
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());
        //第一次添加
        list.add("a");
        System.out.println(list);
        //创建带有参数的list
        ArrayList<String> list2 = new ArrayList<>(12);

        //数组的动态扩容,超过原数组容量则自动扩容1.5倍
        for (int i = 0; i < 10; i++) {
            list2.add(i+"");
        }
        System.out.println(list2);
    }



}
