package homework.test02;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test02_Thread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread thread1 = new MyThread();
        thread1.start();
    }
}
