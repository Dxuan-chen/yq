package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i < chars.length;i ++){
            if(!" ".equals(chars[i])){
                if(hm.get(chars[i]) == null){
                    hm.put(chars[i],1);
                }else {
                    hm.put(chars[i],hm.get(chars[i])+1);
                }
            }
        }
        StringBuilder strs = new StringBuilder();
        for (Character key : hm.keySet()) {
            strs.append(key+"("+hm.get(key)+")");
        }
        System.out.println(strs);
    }
}
