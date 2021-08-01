/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Demo06 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
                for(int i = 0;i < 1000;i ++) {
                    System.out.println("Follow me!"+(i + 1));
                }
        });
        thread.start();
        thread.join();

        System.out.println("rage at!");
    }
}
