/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Demo05 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i = 0;i < 1000;i ++){
                System.out.println("thread的优先级："+Thread.currentThread()+""+i);
            }
        });
//        System.out.println("thread的优先级："+thread.getPriority());

        thread.setPriority(8);
        thread.start();

        Thread mainThread = Thread.currentThread();
//        System.out.println(mainThread.getPriority());
        for(int i = 0;i < 1000;i ++){
            System.out.println("main"+i);
        }
    }
}
