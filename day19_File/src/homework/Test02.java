package homework;

import java.util.Scanner;

/**
 * 功能描述：递归求阶乘
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        int num = sc.nextInt();
        System.out.println("结果："+getSum(num));
    }

    private static int getSum(int num) {
        if(num == 2){
            return 2;
        }
        return num*getSum(num-1);
    }
}
