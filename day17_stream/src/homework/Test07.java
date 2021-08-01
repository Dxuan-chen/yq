package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Test07 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        int count = 10;
        int n = 0;
        List<String> list2;

        while (n < list.size()){
            list2 = list.stream().skip(n).limit(count).collect(Collectors.toList());
            System.out.println(list2);
            n += list2.size();
        }
    }
}
