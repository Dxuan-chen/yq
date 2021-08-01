package 线程安全;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class SynchronizedDemo02 {
    public static void main(String[] args) {
        MyShower myShower2 = new MyShower();
        new Thread(()->myShower2.show()).start();
        new Thread(()->myShower2.show2()).start();

    }
}

class MyShower{

    /**
    * 世界那么大
    * synchronized:修饰方法，如果方法是非静态方法，锁的是this对象
    * synchronized:修饰方法，如果方法是静态方法，锁的是字节码对象this.getclass()对象
    */
    public synchronized static void show(){
        System.out.print("世");
        System.out.print("界");
        System.out.print("那");
        System.out.print("么");
        System.out.print("大");
    }

    public synchronized void show2(){
        System.out.print("我");
        System.out.print("想");
        System.out.print("去");
        System.out.print("看");
        System.out.print("看");
    }
}