import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class Demo02 {

    @Test
    public void test01() {
        String[] array = {"abcd","hello world","java","c++","mysql"};
        //Steam 的创建：数组 stream()
        Stream<String> stream = Arrays.stream(array);

        //找出长度大于4的元素输出
        stream.filter(a -> a.length()>4).forEach(System.out::println);
        //Stream不会改变元数据，会产生一个新的集合或值
        System.out.println(Arrays.toString(array));

        //Stream的静态方法of创建Stream  本质就是Arrays.stream(array);
        Stream<String> stringStream = Stream.of("abcd","hello world","java","c++","mysql");

        stringStream = stringStream.filter(a -> {
            System.out.println("进入filter："+a);
            return a.length()>4;
        });

        //遍历处理先执行，然后在执行forEach的时候，触发中间操作的执行，所有"进入.."的输出都是在后面
        System.out.println("遍历处理：");
        stringStream.forEach(System.out::println);
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        //串行流
        list.stream().filter(i -> i>4 ).forEach(System.out::println);

        //并行流
        list.parallelStream().filter(i -> i>4).forEach(System.out::println);
    }

    @Test
    public void test03(){

    }
}
