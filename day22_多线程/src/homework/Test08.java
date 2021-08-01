package homework;

import homework.test02.MyRunnable;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test08 {
    public static void main(String[] args) {
        new Thread(new MyRunnable08(10),"第一个线程").start();
        new Thread(new MyRunnable08(5),"第二个线程").start();
        new Thread(new MyRunnable08(8),"第三个线程").start();
    }
}

class MyRunnable08 implements Runnable{
    Object object = new Object();
    int num = 0;

    public MyRunnable08(int num){
        this.num = num;
    }

    @Override
    public void run() {
        synchronized(object){
            System.out.println(Thread.currentThread().getName()
            +"计算"+num+"!("+num+"的阶乘）="+sum(num));
        }
    }

    private int sum(int num){
        if(num == 1){
            return 1;
        }
        return sum(num - 1)*num;
    }
}
