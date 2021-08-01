package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Test09 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"hris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        List list2 = list.stream().filter(e -> e.length() > 4).collect(Collectors.toList());
        List list3 = list.stream().map(e -> e = "This is " + e).collect(Collectors.toList());
        System.out.println(list2);
        for (Object o : list3) {
            System.out.println(o);
        }

        List list4 = list.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
        System.out.println(list4);

    }
}
