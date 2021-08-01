package homework.test07;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class Test07 {
    public static void main(String[] args) {
        new Thread(new MyRunnable(),"后门").start();
        new Thread(new MyRunnable(),"前门").start();;

    }
}



