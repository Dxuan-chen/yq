package homework;

import java.util.Scanner;

/**
 * 功能描述：梁老师走楼梯，每次可以走一步或两步，n个楼梯的走法有多少？
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入楼梯个数n：");
            int sum = sc.nextInt();
            System.out.println("总共有"+fun(sum)+"种走法");
        }
    }
    public static int fun(int sum){
        if(sum == 1){
            return 1;
        }
        if(sum == 2){
            return 2;
        }
        return fun(sum - 1) + fun(sum - 2);
    }
}
