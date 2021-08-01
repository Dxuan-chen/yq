package homework;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test03 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("播放背景音乐");
                }
            }
        });
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("显示画面");
                }
            }
        }).start();
    }
}
