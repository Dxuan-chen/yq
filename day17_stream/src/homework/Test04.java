package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Test04 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,5,7,9,4);
        Integer number = list.stream().reduce(0,(sum,e) -> sum += e,Integer::sum);
        System.out.println(number);
    }
}
