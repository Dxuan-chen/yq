package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 */
public class test04 {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();

        hm.put("中国","北京");
        hm.put("韩国","首尔");
        hm.put("俄罗斯","莫斯科");
        hm.put("美国","纽约");
        hm.put("日本","东京");


        Set<String> keySet = hm.keySet();

        Iterator it = keySet.iterator();
        while (it.hasNext()){
            String key = (String)it.next();
            String value = hm.get(key);

            System.out.println(key+":"+value);
        }
    }
}
