package homework;

import java.util.*;

/**
 *
 */
public class test20 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Random ran = new Random();
        while (set.size()<4){
            String s = "";
            for(int i = 0;i < 8;i ++){
                s += ran.nextInt(10);
            }
            set.add(s);
        }
        String[] strs = new String[]{"苹果","香蕉","西瓜","橘子"};
        int i = 0;
        for (String s : set) {
            map.put(s,strs[i++]);
        }
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s+"="+map.get(s));
        }
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("商品号：");
            String number = sc.nextLine();
            if (map.get(number) == null) {
                System.out.println("查无此商品");
            } else {
                System.out.println("根据商品号：" + number + "，查询到对应的商品为：" + map.get(number));
            }
        }
    }
}
