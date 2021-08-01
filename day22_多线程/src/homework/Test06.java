package homework;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/14
 */
public class Test06 {
    public static void main(String[] args) {
        Thread thread01 = new Thread(new MySynchronized(),"前门上车");
        thread01.start();
        new Thread(new MySynchronized(),"中门上车").start();
        new Thread(new MySynchronized(),"后门上车").start();

    }
}

class MySynchronized implements Runnable{
    static int num = 80;
    String str = new String();

    @Override
    public void run() {
        while(num > 0){
            synchronized(str){
                if(num > -1){
                    System.out.println(Thread.currentThread().getName()
                    +"——还剩"+(--num)+"个座位数");
                }else {
                    --num;
                    System.out.println("坐满则不能再上车");
                }
            }
        }
    }
}
