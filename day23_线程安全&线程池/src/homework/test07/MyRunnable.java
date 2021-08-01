package homework.test07;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class MyRunnable implements Runnable {
    static int number = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                while(number<101) {
                    System.out.println("编号为: " + number + " 的员工 从"+Thread.currentThread().getName()+" 入场! 拿到的双色球彩票号码是:" + DoubleColorBallUtil.create());
                    number++;
                }
            }
        }
    }
}
