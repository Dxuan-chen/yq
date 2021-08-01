package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 */
public class test02 {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();

        hm.put("雅典娜","神圣进军");
        hm.put("刘邦","损人利己");
        hm.put("张飞","画地为牢");

        Set<String> keySet = hm.keySet();

        for (String s : keySet) {
            System.out.println(s);
        }
        System.out.println("---------------------");
        Iterator it = keySet.iterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}
