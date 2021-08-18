package eles;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/8/6
 */
public class Test {

    //二分法查找
    public static int binarySearch(int[] arr,int des){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while (low<high){
            if(des == arr[mid]){
                return mid;
            }else if(des < arr[mid]){
                high = mid - 1;
            }else if (des > arr[mid]){
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
    * == 和 equals的区别：
    * ==和equals的最大区别是一个是运算符，一个是方法。
    * ==：如果比较的对象是基本数据类型，则比较的是数值是否相等；
    *   如果比较的是引用数据类型，则比较的是对象的地址值是否相等
    * equals()：用来比较两个对象的内容是否相等。
    * equals方法不能用于基本数据类型的变量，如果没有对equals方法进行重写，
    * 则比较的是引用类型的变量所指向的对象的地址。
    */

    /*
    * 重载（Overload）和重写（Override）的区别：
    * 方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，
    * 而后者实现的是运行时的多态性。重载发生在一个类中，同名的方法如果有不同的
    * 参数列表（参数类型不用、参数个数不同或者二者都不同）则视为重载；
    * 重写发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的参数列表，
    * 有兼容的返回类型，比父类重写方法更好访问，不能比父类重写方法声明更多的
    * 异常（里氏替换原则）。重载对返回类型没有特殊的要求，不能根据返回类型进行区分。
    */

    /*
    * 为什么需要三次握手以及四次挥手？
    * 为什么需要三次握手才能建立连接？
    * 为了初始化序列号的初始值，要通知双方数据包的序号，作为以后通讯的的序号，
    * 以保证在网络传输过程，不会因为网络原因二导致乱序。
    * 为什么需要四次挥手才能断开连接？
    * 因为全双工，发送方和接受方都需要FIN报文和ACK报文
    */

    /*
    * hashmap的工作原理以及扩容机制是怎么样的？
    *
    *
    */


}


class WaitTest{
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition con1 = lock.newCondition();
        Condition con2 = lock.newCondition();
        Condition con3 = lock.newCondition();
        final int[] index = {1};
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (index[0] != 1) {
                    try {
                        con1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                index[0] = 2;
                con2.signal();
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i ++){
                lock.lock();
                while(index[0] != 2){
                    try {
                        con2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                index[0] = 3;
                con3.signal();
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10; i ++){
                lock.lock();
                while(index[0] != 3){
                    try {
                        con3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                index[0] = 1;
                con1.signal();
                lock.unlock();
            }
        }).start();


    }
}


