package enums;

import java.util.Arrays;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Demo03 {
    public static void main(String[] args) {
        Direction3 behind = Direction3.BEHIND;
        behind.show();

        //枚举和switch
        //当switch匹配枚举项的时候，会自动根据
        // 传入的比较对象behind找到其枚举类型，从中取出每个枚举项，放入到case中匹配
        switch(behind){
            case BEHIND:
                System.out.println("往前走");break;
            case FRONT:
                System.out.println("往后走");break;
            case LEFT:
                System.out.println("往左走");break;
            case RIGHT:
                System.out.println("往右走");break;
        }

    }
}


enum Direction3{
    /**
    * 创建枚举实例的同时，必须要实现抽象方法show
    * 1.创建—个枚举子类型，实现了show方法
    * 2.创建该子类型对象
    */
    FRONT() {
        @Override
        public void show() {
            System.out.println("FRONT...");
        }
    },
    BEHIND() {
        @Override
        public void show() {
            System.out.println("BEHIND...");
        }
    },
    LEFT {
        @Override
        public void show() {
            System.out.println("LEFT...");
        }
    },
    RIGHT{
        @Override
        public void show() {
            System.out.println("RIGHT...");
        }
    };


    //枚举构造器
    Direction3(){
        System.out.println("构造器创建...");
    }

    //枚举中可以使用抽象方法，直接声明方法为abstract，但是类不能加abstract，
    //同时声明枚举项的时候必须通过内部类实现方法
    public abstract void show();

}
