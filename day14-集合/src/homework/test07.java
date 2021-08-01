package homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class test07 {
    @Test
    public void test(){
        List<Integer> lists = new ArrayList<>();
        lists.add(33);
        lists.add(11);
        lists.add(77);
        lists.add(55);
        Collections.sort(lists);
        System.out.println(lists);

        Collections.shuffle(lists);
        System.out.println(lists);

        Collections.reverse(lists);
        for (Integer list : lists) {
            System.out.println(list);
        }
    }
}
