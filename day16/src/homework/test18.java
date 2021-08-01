package homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class test18 {
    public static void main(String[] args) {
        HashMap<String,HashMap<Integer,String>> map = new HashMap<>();
        HashMap<Integer,String> map1 = new HashMap<>();
        map1.put(001,"李晨");
        map1.put(002,"范冰冰");
        HashMap<Integer,String> map2 = new HashMap<>();
        map2.put(001,"马云");
        map2.put(002,"马化腾");

        map.put("Java班",map1);
        map.put("嵌入式班",map2);

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s+":"+map.get(s));
        }
        Set<Map.Entry<String, HashMap<Integer, String>>> entries = map.entrySet();
        for (Map.Entry<String, HashMap<Integer, String>> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
