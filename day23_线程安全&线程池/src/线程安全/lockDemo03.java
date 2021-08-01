package 线程安全;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class lockDemo03 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
           for(int i = 0;i < 1000;i ++) {
               lock.lock();
               System.out.print("世");
               System.out.print("界");
               System.out.print("那");
               System.out.print("么");
               System.out.print("大");
               System.out.println();
               lock.unlock();
           }
        }).start();

        new Thread(()->{
            for(int i = 0;i < 1000;i ++){
                lock.lock();
                System.out.print("我");
                System.out.print("想");
                System.out.print("去");
                System.out.print("看");
                System.out.print("看");
                System.out.println();
                lock.unlock();
            }
        }).start();


    }
}


