package homework.test02;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 功能描述：
 */
public class test02 {
    @Test
    public void test(){
        LinkedList<String> lists = new LinkedList<>();
        System.out.println("1."+lists);
        lists.add("成吉思汗");
        lists.add("鬼谷子");
        lists.add("宫本武藏");
        lists.add("周瑜");
        lists.add("小乔");
        System.out.println("2."+lists);

        lists.add(1,"后羿");
        System.out.println("3."+lists);

        lists.set(0,"墨子");
        System.out.println("4."+lists);

        System.out.println("5."+lists.get(0));

        System.out.println("6."+lists.size());

        lists.remove(1);
        System.out.println("7."+lists);

        lists.clear();
        System.out.println("8."+lists);
    }
}
