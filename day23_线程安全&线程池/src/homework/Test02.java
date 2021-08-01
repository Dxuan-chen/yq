package homework;

import java.util.Random;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class Test02 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];
        new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                arr1[i] = new Random().nextInt(100)+1;
            }
        }).start();
        new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                arr2[i] = new Random().nextInt(100)+1;
            }
        }).start();new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                arr3[i] = new Random().nextInt(100)+1;
            }
        }).start();

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0;i < 10;i ++){
            sum1 += arr1[i];
        }
        int avg1 = sum1/10;
        for (int i = 0;i < 10;i ++){
            sum1 += arr1[i];
        }
        int avg2 = sum1/10;
        for (int i = 0;i < 10;i ++){
            sum1 += arr1[i];
        }
        int avg3 = sum1/10;
        int avg = (avg1+avg2+avg3)/3;
        System.out.println(avg);

    }
}
