package 线程安全;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class WaitDemo06 {
    /**
     * wait()方法:
     * 1.在锁住的代码中调用
     * 2.当前线程让出执行权，进入到等待阻塞中，让出对象锁
     * 3.出发别的线程调用notify()或notifyALL否则会一直等待
     * 4.wait()和notify等方法，是锁对象调用的。继承自Object
     */
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized(o) {
                try {
                    System.out.println("进入线程执行任务，然后让出对象锁...");
                    o.wait();//表示当前对象上的锁释放，也就是当前执行的线程放弃锁
                    System.out.println(Thread.currentThread().getName()+"-等待结束，继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"进入线程执行任务，等待2秒");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(o){
                o.notify();//随机唤醒当前等待获取对象锁的线程，进入锁阻塞状态，等待获取锁
                o.notifyAll();//唤醒当前等待对象的所有线程
                System.out.println("唤醒其他取同样对象锁的线程");

            }

        }).start();
    }
}
