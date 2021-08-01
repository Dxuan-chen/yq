package list;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/2
 */
public class Demo2 {

    @Test
    public void test01(){
        LinkedList<String> linkedList = new LinkedList<>();

        //队列首尾操作
        linkedList.addFirst("a");
        linkedList.addFirst("b");
        System.out.println(linkedList);
        linkedList.addLast("e");
        linkedList.addLast("f");
        System.out.println(linkedList);
        String first = linkedList.getFirst();
        System.out.println("头部元素："+first);
        System.out.println("尾部元素："+linkedList.getLast());
        System.out.println("头部被删除元素："+linkedList.removeFirst());
        System.out.println("尾部被删除元素："+linkedList.removeLast());
        System.out.println(linkedList);

        System.out.println("---------------------");
        //栈的操作
        linkedList.clear();
        linkedList.push("a");
        linkedList.push("b");// b a
        System.out.println(linkedList);
        System.out.println("弹出栈顶元素："+linkedList.pop());
    }
}
