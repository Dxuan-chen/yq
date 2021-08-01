package enums;

import java.lang.annotation.Retention;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Demo01 {
    public static void main(String[] args) {
        //每个枚举项都等于是该枚举的对象
        Direction left = Direction.LEFT;
        System.out.println(left.name());//LEFT
        //多次获取是同一个枚举对象枚举是单例实现
        Direction left2 = Direction.RIGHT;
        System.out.println(left == left);//true

    }
}
enum Direction{
    //枚举项
    FRONT,BEHIND,LEFT,RIGHT;
    //枚举构造器
    private  Direction(){
        System.out.println("构造器创建...");
    }
}
