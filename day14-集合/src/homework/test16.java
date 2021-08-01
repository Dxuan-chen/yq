package homework;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 */
public class test16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        HashSet<Integer> hs = new HashSet<>();
        System.out.println("请输入数字（-1退出）：");
        num = sc.nextInt();
        while(num != -1){
            hs.add(num);
            System.out.println("请输入数字（-1退出）：");
            num = sc.nextInt();
        }
        int sum = 0;
        for (Integer n : hs) {
            sum += n;
        }
        System.out.println("sum:"+sum);
        System.out.println("平均值："+sum/hs.size());
    }

}
