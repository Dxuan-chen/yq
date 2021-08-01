package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class test05 {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();

        hm.put("中国","北京");
        hm.put("韩国","首尔");
        hm.put("俄罗斯","莫斯科");
        hm.put("美国","纽约");
        hm.put("日本","东京");

        Set<Map.Entry<String, String>> entries = hm.entrySet();
        Iterator it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry<String,String>)it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);

        }
    }
}
