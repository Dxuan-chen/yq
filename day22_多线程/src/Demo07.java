/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Demo07 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i = 1;i < 10000;i ++){
                System.out.println("thread线程已完成："+i/100);
                if(i%10==0){
                    System.out.println("礼让");
                    Thread.yield();
                }
            }
        });

        thread.start();

        Thread thread1 = new Thread(()->{
           for(int i = 0;i < 10000;i++){
               System.out.println("thread1线程"+i);
           }
        });

        thread1.start();

    }
}
