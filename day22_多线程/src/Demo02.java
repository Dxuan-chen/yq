/**
 * 功能描述：
 *
 * 多线程执行原理:
 * 1.main方法执行，启动main线程
 * 2.执行到threade2.start()，启动新线程，交由CPU调度使用
 */
public class Demo02 {
    public static void main(String[] args) {
        MyThread02 thread02 = new MyThread02();

        //启动线程，交给CPU进行调度处理
        thread02.start();
        Thread thread = Thread.currentThread();
        System.out.println("main优先级："+thread.getPriority());
        System.out.println("main线程执行完毕...");
        for(int i = 0;i < 10;i ++){
            System.out.println(thread+""+i);
        }
    }

}
