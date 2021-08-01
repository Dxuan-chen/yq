package homework.test06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class test06 {
    public static void main(String[] args) {
        HashMap<String,Student> hm = new HashMap<>();
        hm.put("海珠",new Student("小明",23));
        hm.put("天河",new Student("小红",20));
        hm.put("白云",new Student("小华",21));

        Set<String> keys = hm.keySet();
        for (String key : keys) {
            Student value = hm.get(key);
            System.out.println(key+":"+value);
        }
        System.out.println("---------------------");

        Set<Map.Entry<String,Student>> entries = hm.entrySet();
        Iterator it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<String,Student> entry = (Map.Entry<String,Student>)it.next();
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key+":"+value);
        }

    }
}
