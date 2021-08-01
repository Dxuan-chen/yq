package homework;

import org.junit.Test;

import java.util.LinkedList;

/**
 *
 */
public class test03 {
    @Test
    public void test(){
        LinkedList<String> lists = new LinkedList<>();
        lists.add("成吉思汗");
        lists.add("鬼谷子");
        lists.add("宫本武藏");
        lists.add("周瑜");
        lists.add("小乔");
        System.out.println("1."+lists);

        lists.add("后羿");
        System.out.println("2."+lists);

        lists.addFirst("鲁班七号");
        System.out.println("3."+lists);

        lists.addLast("墨子");
        System.out.println("4."+lists);

        System.out.println("5."+lists.getFirst());

        System.out.println("6."+lists.getLast());

        lists.removeFirst();
        System.out.println("7."+lists);

        lists.removeLast();
        System.out.println("8."+lists);

    }
}
