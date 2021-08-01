package homework;

import java.util.HashMap;

/**
 *
 */
public class test09 {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("小乔",2100);
        hm.put("张昭",1700);
        hm.put("诸葛亮",1800);
        hm.put("周瑜",2600);
        hm.put("孙权",3800);

        int value = hm.get("小乔");
        hm.put("小乔",value+300);

        for (String key : hm.keySet()) {
            value = hm.get(key);
            System.out.println(key+":"+value);
        }

    }
}
