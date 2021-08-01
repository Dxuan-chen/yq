package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class test10 {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(1,"张三丰");
        hm.put(2,"周芷若");
        hm.put(3,"汪峰");
        hm.put(4,"灭绝师太");
        Set<Integer> keys = hm.keySet();
        for (Integer key : keys) {
            String value = hm.get(key);
            System.out.println(key+":"+value);
        }
        System.out.println("--------------");
        hm.put(5,"李晓红");
        hm.remove(1);
        hm.put(2,"周林");
        for (Integer key : keys) {
            String value = hm.get(key);
            System.out.println(key+":"+value);
        }
    }
}
