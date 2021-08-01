package homework;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class test08 {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(hm.size()<5) {
            System.out.println("姓名，年龄");
            String input = sc.nextLine();
            String[] strs = input.split("，");
            hm.put(strs[0],Integer.parseInt(strs[1]));
        }
        for (String key : hm.keySet()) {
            System.out.println(key+":"+hm.get(key));
        }
    }
}
