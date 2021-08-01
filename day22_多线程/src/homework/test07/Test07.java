package homework.test07;

import homework.test02.MyThread;
import homework.test05.MySynchronized;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test07 {
    public static void main(String[] args) {
        new Thread(new MyThread07(),"窗口a").start();
        new Thread(new MyThread07(),"窗口b").start();
        new Thread(new MyThread07(),"窗口c").start();

    }
}

class MyThread07 extends Thread{
    static int num = 100;
    String s = new String();

    @Override
    public void run() {
        while(num > 0){
            synchronized(s){
                System.out.println(Thread.currentThread().getName()
                        +"卖了一张票，剩余票数为"+(--num));

            }
        }
    }
}
