package homework;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0;i < chars.length;i ++){
            if(chars[i]==' '){
                countingKey(hm,"空格");
            }else if((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z')){
                countingKey(hm,"字母");
            }else if(chars[i]>=48&&chars[i]<=57){
                countingKey(hm,"数字");
            }else {
                countingKey(hm,"其他");
            }
        }
        for (String s : hm.keySet()) {
            System.out.println(s+":"+hm.get(s));
        }

    }

    public static void countingKey(HashMap hm,String key){
                if(hm.get(key) == null){
                    hm.put(key,1);
                }else {
                    hm.put(key,(int)hm.get(key)+1);
                }
    }
}
