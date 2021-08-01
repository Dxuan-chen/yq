package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用:
 * 1.通过Executors获取线程池服务对象（Executorservice）
 * 2.通过服务对象获取线程，执行任务
 * 3.归还线程给线程池
 * 4.关闭池(一般不需要关闭)
 */
public class ExecutorsDemo09 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("来个教练");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("教我狗爬式...");
                System.out.println("教完了...");
            }
        };
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(runnable);
        threadPool.submit(runnable);

        //关闭线程池
        threadPool.shutdown();
    }
}
