package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,6,7,8,1,2,3,9);
        List<Integer> list2 = list.stream().filter(e -> e > 7).collect(Collectors.toList());
        list2.stream().forEach(System.out::println);
    }
}
