package file;

import org.junit.Test;

/**
 * 递归
 */
public class Demo02 {
    @Test
    public void test02(){
        System.out.println("递归");
        add(1);
    }

    public void add(int i){
        System.out.println("add执行..."+i);
        if(i == 3){
            return;
        }
        add(++i);
    }
}
