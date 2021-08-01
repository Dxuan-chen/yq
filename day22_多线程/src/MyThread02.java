/**
 *
 */
public class MyThread02 extends Thread{

    //run:
    //定义线程执行逻辑的方法，当线程执行的时候，就会自动运行run的逻辑
    //不能自己调用，需要交给CPU进行调度调用
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("优先级"+thread.getPriority());
        for(int i = 0;i < 10;i ++){
            System.out.println(thread+""+i);
        }
    }
}
