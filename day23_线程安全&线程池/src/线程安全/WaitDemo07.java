package 线程安全;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class WaitDemo07 {
    public static void main(String[] args) {
        final int[] index = {1};
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                lock.lock();
                    while (index[0] != 1){
                        try {
//                            "".wait();
                            condition1.await();//等待  并监视当前线程
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("我");
                    System.out.print("是");
                    System.out.print("中");
                    System.out.print("国");
                    System.out.print("人");
                    System.out.println();

                    index[0] = 2;
//                    "".notifyAll();
                    condition2.signal();//唤醒指定线程
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                lock.lock();
                    while (index[0] != 2){
                        try {
//                            "".wait();
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("世");
                    System.out.print("界");
                    System.out.print("那");
                    System.out.print("么");
                    System.out.print("大");
                    System.out.println();

                    index[0] = 3;
//                    "".notifyAll();
                    condition3.signal();
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                lock.lock();
                    while (index[0] != 3){
                        try {
//                            "".wait();
                            condition3.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("我");
                    System.out.print("想");
                    System.out.print("去");
                    System.out.print("看");
                    System.out.print("看");
                    System.out.println();

                    index[0] = 1;
//                    "".notifyAll();
                    condition1.signal();
                lock.unlock();
            }
        }).start();

    }
}
