package homework;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<String,Integer> hm = new HashMap<>();
        String[] strs = input.split(" ");
        for(int i = 0;i < strs.length;i ++){
            if(!" ".equals(strs[i])){
                if(hm.get(strs[i]) == null){
                    hm.put(strs[i],1);
                }else {
                    hm.put(strs[i],hm.get(strs[i])+1);
                }
            }
        }
        for (String s : hm.keySet()) {
            System.out.println(s+" = "+hm.get(s));
        }
    }
}
