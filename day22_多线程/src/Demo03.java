import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Demo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread03 thread03 = new MyThread03("thread03子线程");
        thread03.start();


        MyThread03_02 runnable = new MyThread03_02();
        new Thread(runnable).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Runnable...");
            }
        }).start();

        /**
        * 1.定义calLable类，实现caLl方法
        * 2.定义FutureTask类（RunnabLe子类），创建任务对象
        * 3.创建线程类，传入FutureTask类对象
        *
        */
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for( int i = 0;i < 1000;i ++){
                    sum += i;
                }
                return sum;
            }
        };
        //定时任务对象，根据Callable对象创建
        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread thread1 = new Thread(task);
        thread1.start();
        //task.get():等待task任务执行完毕后获取返回值,必须启动任务后才能调用
        System.out.println(task.get());
        System.out.println(task.isDone());

        /**
        *Thread继承、Runnable.calLable实现线程任务区别:
        * 1.Thread继承方式会让类扩展性差，如果只需要执行一次，显得多余
        * 2.Runnable、Callable不需要写一个子类实现继承，扩展性好，代码简洁
        * 3.线程池只支持Runnable、callabLe实现方式
        * 4.RunnabLe简洁，不能返回结果，不能抛出异常
        * 5.Callable比较繁琐(必须依赖FutureTask实现)，可以返回结果，可以抛出异常，
        */     
        
    }
}

class MyThread03 extends Thread{
    public MyThread03(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("我是子线程");
    }
}

class MyThread03_02 implements Runnable {

        @Override
        public void run() {
            System.out.println("实现Runnalbe接口的子类实现方式...");
        }
}
