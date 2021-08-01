import java.io.ObjectOutputStream;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Synchronized {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SellRunnable());
        thread1.start();

        Thread thread2 = new Thread(new SellRunnable());
        thread2.start();
        Thread thread3 = new Thread(new SellRunnable());
        thread3.start();
    }
}

class SellRunnable implements Runnable{
    static int ticket = 10000;
    static Object object = new Object();

    @Override
    public void run() {
        while(ticket>0){
            //this:当前对象﹑锁this表示锁的对象是当前jvm的堆中创建的TicketRunnable类的对象
            //this.getClass():表示锁的对象是当前方法区创建的TicketRunnable.class的对象

            synchronized(this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出票：" + (10001 - ticket));
                    ticket--;
                    System.out.println("剩余票：" + ticket);
                }
            }
        }
    }
}
