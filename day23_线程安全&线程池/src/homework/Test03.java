package homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class Test03 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Thread thread01 = new Thread(() -> {
            int sum = 1;
            for(int i = 10;i >= 1;i --){
               sum *= i;
            }
            System.out.println(Thread.currentThread().getName()+":10!="+sum);
        });
        Thread thread02 = new Thread(() -> {
            int sum = 1;
            for(int i = 5;i >= 1;i --){
                sum *= i;
            }
            System.out.println(Thread.currentThread().getName()+":5!="+sum);

        });
        Thread thread03 = new Thread(() -> {
            int sum = 1;
            for(int i = 8;i >= 1;i --){
                sum *= i;
            }
            System.out.println(Thread.currentThread().getName()+":8!="+sum);

        });

        pool.submit(thread01);
        pool.submit(thread02);
        pool.submit(thread03);
    }
}
