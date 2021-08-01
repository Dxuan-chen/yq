package enums;

import java.util.Arrays;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Demo02 {
    public static void main(String[] args) {
        Direction2 front = Direction2.FRONT;
        System.out.println(front);
        System.out.println(front.getName());
        System.out.println("枚举实例顺序："+front.ordinal());
        Direction2 behind = Direction2.BEHIND;
        System.out.println("枚举实例顺序："+behind.ordinal());
        System.out.println("比较大小："+front.compareTo(behind));//0减1=-1
        Direction2[] values = Direction2.values();
        System.out.println("获取所有的枚举项："+ Arrays.toString(values));
        //根据枚举项名字获取枚举实例
        Direction2 front2 = Direction2.valueOf("FRONT");
        System.out.println(front2);

    }
}

//除了自己声明的方法外，枚举还会自动继承Enum中的方法
enum Direction2{
    //枚举项的声明就是创建枚举实例对象
    //默认调用无参构造方法 可以省略
    //调用指定参数的构造方法 枚举项(参数列表)
    FRONT("前"),
    BEHIND("后"),
    LEFT("左"),
    RIGHT("右");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //枚举构造器
    /*private  */Direction2(){
        System.out.println("构造器创建...");
    }

    /*private  */Direction2(String name){
        this.name = name;   //记得写
        System.out.println("构造器name创建...");
    }
}
