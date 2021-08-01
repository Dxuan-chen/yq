package homework.test07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class test07 {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<>();
        hm.put(new Student("小明",23),"海珠");
        hm.put(new Student("小红",20),"天河");
        hm.put(new Student("小华",21),"白云");

        Set<Student> keys = hm.keySet();
        for (Student key : keys) {
            String value = hm.get(key);
            System.out.println(key+":"+value);
        }
        System.out.println("---------------------");

        Set<Map.Entry<Student, String>> entries = hm.entrySet();
        Iterator it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<Student, String> entry = (Map.Entry<Student, String>)it.next();
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);
        }

    }
}
