package homework;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class test17 {
    public static void main(String[] args){
        ArrayList<String> lists1 = new ArrayList<>();
        lists1.add("a");
        lists1.add("b");
        lists1.add("a");
        lists1.add("c");
        lists1.add("d");
        ArrayList<String> lists2 = new ArrayList<>();
        lists2.add("e");
        lists2.add("f");
        lists2.add("a");
        lists2.add("d");
        lists2.add("g");
        HashSet<String> hs = new HashSet<>();
        for(int i = 0;i < lists1.size();i ++){
            hs.add(lists1.get(i));
        }
        for (String s : lists2) {
            hs.add(s);
        }
        for (String h : hs) {
            System.out.println(h);
        }

    }
}
