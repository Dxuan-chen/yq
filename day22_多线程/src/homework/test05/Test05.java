package homework.test05;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test05 {
    public static void main(String[] args) {
        Thread thread01 = new Thread(new MySynchronized(),"实体店");
        thread01.start();
        new Thread(new MySynchronized(),"官网").start();
    }
}
