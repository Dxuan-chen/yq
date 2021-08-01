package homework;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class test13 {
    public static void main(String[] args) {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("abc");
        lists.add("bcd");
        HashMap<Character,Integer> hm = new HashMap<>();
        for (String s : lists) {
            char[] chars = s.toCharArray();
            for(int i = 0;i < chars.length;i ++){
                if(!" ".equals(chars[i])){
                    if(hm.get(chars[i]) == null){
                        hm.put(chars[i],1);
                    }else {
                        hm.put(chars[i],hm.get(chars[i])+1);
                    }
                }
            }
        }
        for (Character key : hm.keySet()) {
            System.out.println(key+" = "+hm.get(key));
        }
    }
}
