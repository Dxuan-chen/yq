package homework;

/**
 * 功能描述：求1到n的和(n>=100 &&n<=200)
 */
public class Test11 {
    public static void main(String[] args) {
        int num = 160;
        System.out.println("1到"+num+"的和为："+sum(num));

    }

    private static int sum(int num) {
        if(num == 1){
            return 1;
        }
        return num + sum(num - 1);
    }
}
