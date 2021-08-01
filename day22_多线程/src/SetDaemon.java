/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class SetDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
           for(int i = 0;i < 10000;i ++){
               System.out.println("守护线程执行："+i);
           }
        });
        thread.setDaemon(true);//设置为守护线程
        thread.start();

        new Thread(()->{
            for(int i = 0;i < 10;i ++){
                System.out.println("用户线程1："+i);
            }
            System.out.println("用户线程1结束");
        }).start();

        System.out.println("-------main执行结束-------");
    }
}
