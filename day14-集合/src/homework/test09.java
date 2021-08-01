package homework;


import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class test09 {
    public static void main(String[] args){
        ArrayList<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add("f");
        lists.add("b");
        lists.add("c");
        lists.add("a");
        lists.add("d");

        HashSet<String> sets = new HashSet<>();
        sets.addAll(lists);
        System.out.println("HashSet:"+sets);
        lists.clear();
        System.out.println("lists:"+lists);
        lists.addAll(sets);
        System.out.println("lists:"+lists);


    }
}
