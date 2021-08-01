package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *使用lambda和stream完成2个集合{1,2,3}和{3,4,5}的差集，并集，交集操作
 */
public class Test06 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Collections.addAll(list1,1,2,3);
        Collections.addAll(list2,3,4,5);

        List<Integer> list3 = list1.stream().filter(
                e1 -> !list2.stream().collect(Collectors.toList()).contains(e1))
                .collect(Collectors.toList());
        System.out.println("差集："+list3);

        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        List<Integer> list4 = list.stream().distinct().collect(Collectors.toList());
        System.out.println("交集："+list4);

        List<Integer> list5 = list1.stream().filter(
                e1 -> list2.stream().collect(Collectors.toList()).contains(e1))
                .collect(Collectors.toList());
        System.out.println("交集："+list5);


    }
}
