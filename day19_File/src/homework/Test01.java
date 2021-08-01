package homework;

/**
 * 功能描述：计算1～n的和
 */
public class Test01 {
    public static void main(String[] args) {
        int num = 5;
        int sum = getSum(num);
        System.out.println(sum);
    }

    private static int getSum(int num) {
        if(num == 2){
            return 2+1;
        }
        return num+getSum(num-1);
    }
}
