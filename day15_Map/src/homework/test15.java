package homework;

import java.util.*;

/**
 *
 */
public class test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        HashMap<String,Integer> hm = new HashMap<>();
        while(hm.size()<5) {
            System.out.println("请输入姓名：");
            String name = sc.nextLine();
            int score = ran.nextInt(101);
            hm.put(name, score);
        }
            Set<Map.Entry<String, Integer>> entries = hm.entrySet();
            Iterator it = entries.iterator();
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) it.next();
            String key = entry.getKey();
            int value = entry.getValue();
            int sum = 0;
            int high = value;
            int low = value;
            Set<String> keys = hm.keySet();
            for (String k : keys) {
                int v = hm.get(k);
                sum += v;
                if(high < v){
                    high = v;
                }
                if(low > v){
                    low = v;
                }
            }
            int avg = sum/hm.size();
            System.out.println("总分 = "+sum+",最高分 = "+high+",最低分 = "+low+",平均分 = "+avg);


    }
}
