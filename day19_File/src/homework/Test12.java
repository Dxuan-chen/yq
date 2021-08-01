package homework;

import java.util.Scanner;

/**
 * 功能描述：求整数n的阶乘(n<=10)
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入整数n(n<=10)：");
            int num = sc.nextInt();
            if(num > 10){
                System.out.println("输入错误！");
                continue;
            }
            System.out.println(num+"的阶乘为："+sum(num));

        }
    }

    private static int sum(int num) {
        if(num == 1){
            return 1;
        }
        return num*sum(num-1);
    }
}
