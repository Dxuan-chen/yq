package homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Test03 {
    public static void main(String[] args) {
        String[] strs = {"abcd","bcde","defgh","efg"};
        List<String> list = Arrays.stream(strs).map(e -> e.toUpperCase()).collect(Collectors.toList());
        System.out.println(list);
    }
}
