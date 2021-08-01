package homework.test05;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class MySynchronized implements Runnable {
    static int num = 100;
    private Object object = new Object();

    @Override
    public void run() {
        while (num > 0){
            synchronized(object){
                System.out.println(Thread.currentThread().getName()
                        +"卖出第"+(100-num)+"个，总共剩余"+(num--)+"个");

            }
        }
    }
}
