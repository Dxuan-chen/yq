package homework;

import java.util.HashMap;
import java.util.Set;

/**
 *
 */
public class test01 {
    public static void main(String[] args) {
        HashMap<String,String> hm= new HashMap<>();
        hm.put("程咬金","爆裂双斧");
        hm.put("白起","死神之镰");
        hm.put("张飞","画地为牢");

        hm.put("张飞","狂兽血性");

        System.out.println(hm.get("程咬金"));

        hm.remove("白起");

        Set<String> keySet = hm.keySet();
        for (String s : keySet) {
            System.out.println(hm.get(s));
        }

    }
}
