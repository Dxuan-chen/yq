package test03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Test03_01 {
    static int sum = 100;
    static int index = 1;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        Condition condition4 = lock.newCondition();

        new Thread(()->{
            while(true) {
                lock.lock();
                if(sum > 0) {
                    while (index != 1) {
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    --sum;
                    System.out.println("第一个窗口卖了" + (100 - sum) + "张票，剩" + sum + "张");
                    ++index;
                    condition2.signal();
                    lock.unlock();
                }
            }
        }).start();

        new Thread(()->{
            while(true) {
                lock.lock();
                if (sum > 0)
                    while (index != 2) {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                --sum;
                System.out.println("第二个窗口卖了" + (100 - sum) + "张票，剩" + sum + "张");
                ++index;
                condition3.signal();
                lock.unlock();

            }
        }).start();

        new Thread(()->{
            while(sum > 0) {
                lock.lock();
                if(true) {
                    while (index != 3) {
                        try {
                            condition3.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    --sum;
                    System.out.println("第三个窗口卖了" + (100 - sum) + "张票，剩" + sum + "张");
                    ++index;
                    condition4.signal();
                    lock.unlock();
                }
            }
        }).start();

        new Thread(()->{
            while(true) {
                lock.lock();
                if(sum > 0) {
                    while (index != 4) {
                        try {
                            condition4.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    --sum;
                    System.out.println("第四个窗口卖了" + (100 - sum) + "张票，剩" + sum + "张");
                    index = 1;
                    condition1.signal();
                    lock.unlock();
                }
            }
        }).start();
    }
}
