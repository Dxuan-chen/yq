package changelist;

import org.junit.Test;

import java.util.Arrays;

/**
 * 可变参数：
 * JDK1.5以后提供的功能，可以将方法的参数设置为长度可变的
 * 参数的长度可变是指参数可以放入1~n个，本质等于数组
 * 参数只能定义到方法参数列表末尾
 */
public class Demo04 {

    @Test
    public void test01(){
        show("1");
        show("1","2","3");
    }

    /*public void show(String str){

    }

    public void show(String[] str){

    }*/

    public void show(String... str){
        System.out.println(Arrays.toString(str));
    }
}
