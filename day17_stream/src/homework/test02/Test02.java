package homework.test02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
public class Test02 {
    @Test
    public void test01() {
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp("张飞", 8900, 23, "male", "New York"));
        empList.add(new Emp("关羽", 7000, 25, "male", "Washington"));
        empList.add(new Emp("赵云", 7800, 21, "female", "Washington"));
        empList.add(new Emp("刘备", 8200, 24, "female", "New York"));
        empList.add(new Emp("诸葛亮", 9500, 25, "male", "New York"));
        empList.add(new Emp("黄忠", 7900, 26, "female", "New York"));

        Optional<Emp> max = empList.stream().max((e1,e2) -> e2.getSalary() - e1.getSalary());

        System.out.println("工资最高："+max);
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,7,6,4,8,2,11,9);
        Long num = list.stream().filter(e -> e>6).collect(Collectors.counting());

        System.out.println("大于6的元素有"+num+"个");
    }
}
