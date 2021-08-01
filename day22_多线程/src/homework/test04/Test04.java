package homework.test04;

import java.util.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test04 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        while(set.size()<10){
            String name = "person"+(new Random().nextInt(1000));
            set.add(name);
        }
        for (String s : set) {
            Thread thread01 = new Thread(new MySynchronized(),s);
            thread01.start();
        }
    }
}
