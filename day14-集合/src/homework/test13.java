package homework;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class test13 {
    public static void main(String[] args){
        String[] arr = new String[]{"abc","bad","abc","aab","bad","cef","jhi"};
        HashSet<String> sets = new HashSet<>();
        for(int i = 0;i < arr.length;i ++){
            sets.add(arr[i]);
        }
        ArrayList<String> lists = new ArrayList<>();
        lists.addAll(sets);
        System.out.println("Arraylist:"+lists);

    }
}
