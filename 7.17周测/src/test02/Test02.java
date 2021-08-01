package test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Test02 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        final int[] index = {1};
        new Thread(()->{
            lock.lock();
            for(int i = 1;i <= 52;i ++){
                while(index[0] != 1) {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.print(i);
                if(i%2==0) {
                    index[0] = 2;
                    condition2.signal();
                }
            }
            lock.unlock();
        }).start();

        new Thread(()->{
            for(char i = 'A';i <= 'Z';i ++){
                lock.lock();
                while(index[0] != 2) {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(i);
                System.out.print(" ");
                index[0] = 1;
                condition1.signal();
                lock.unlock();
            }
        }).start();
    }
}
