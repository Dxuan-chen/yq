package test03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Test03_02 {
    static int sum = 100;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (sum > 0) {
                        --sum;
                        System.out.println(Thread.currentThread().getName()+"卖了" + (100 - sum) + "张票，剩" + sum + "张");
                    }
                    lock.unlock();
                }
            }
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.submit(runnable1);
        threadPool.submit(runnable1);
        threadPool.submit(runnable1);
        threadPool.submit(runnable1);
    }
}
