package homework.test02;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test02_Runnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
