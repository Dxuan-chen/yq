package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class test016 {
    public static void main(String[] args) {
        HashMap<String,Double> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(map.size()<5){
            System.out.println("请输入书的信息（书名=价格）");
            String in = sc.nextLine();
            String[] split = in.split("=");
            map.put(split[0],Double.parseDouble(split[1]));

        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"="+map.get(key));
        }
        System.out.println("---------------");
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
