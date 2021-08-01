package 线程安全;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class StateDemo05 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> System.out.println("线程"));
        Thread.State ts = t.getState();
        System.out.println(ts);//NEW 创建

        t.start();
        System.out.println(t.getState());//RUNNABLE 可运行

        Thread thread = Thread.currentThread();
        Thread.sleep(1000);
        System.out.println(thread.getState());

    }
}
