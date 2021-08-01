package homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class test08 {
    public ArrayList add(String... strs){
        ArrayList<String> lists = new ArrayList<>();
        for (String str : strs) {
            lists.add(str);
        }
        return lists;
    }

    @Test
    public void test(){
        ArrayList<String> lists = new ArrayList<>();
        lists=add("aaa","ddd","ccc");
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
