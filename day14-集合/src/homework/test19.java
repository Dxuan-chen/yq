package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * 双色球
 */
public class test19 {
    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();
        Random ran = new Random();
        while(hs.size()<6){
            int n = ran.nextInt(33)+1;
            hs.add("红"+n);
        }
        int m = ran.nextInt(16)+1;
        hs.add("蓝"+m);

        for (String s : hs) {
            System.out.println(s);
        }
    }
}
