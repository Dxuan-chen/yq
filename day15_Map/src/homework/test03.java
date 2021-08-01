package homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 */
public class test03 {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();

        hm.put("雅典娜","神圣进军");
        hm.put("刘邦","损人利己");
        hm.put("张飞","画地为牢");

        Collection<String> values = hm.values();

        for (String s : values) {
            System.out.println(s);
        }
        System.out.println("---------------------");
        Iterator it = values.iterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}
