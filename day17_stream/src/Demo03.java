import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Demo03 {
    List<Emp> empList = new ArrayList<>();

    @Before
    public void before(){
        empList.add(new Emp("张飞", 8900, 23, "male", "New York"));
        empList.add(new Emp("关羽", 7000, 25, "male", "Washington"));
        empList.add(new Emp("赵云", 7800, 21, "female", "Washington"));
        empList.add(new Emp("刘备", 8200, 24, "female", "New York"));
        empList.add(new Emp("诸葛亮", 9500, 25, "male", "New York"));
        empList.add(new Emp("黄忠", 7900, 26, "female", "New York"));

    }


    @Test
    public void test02(){


        Optional<Emp> min = empList.stream().min((emp,emp2) -> emp2.getAge() - emp.getAge());
        System.out.println(min.get());

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,5,6,8,2,9,1);
        Optional min2 = list.stream().min(Integer::compareTo);

    }

    @Test
    public void test03(){
        List<Emp> list = new ArrayList<>();
        list.add(new Emp("张飞", 8900, 23, "male", "New York"));
        list.add(new Emp("关羽", 7000, 25, "male", "Washington"));
        list.add(new Emp("赵云", 7800, 21, "female", "Washington"));
        list.add(new Emp("刘备", 8200, 24, "female", "New York"));
        list.add(new Emp("诸葛亮", 9500, 25, "male", "New York"));
        list.add(new Emp("黄忠", 7900, 26, "female", "New York"));

        list.stream().map(e -> {
            Emp emp = new Emp(e.getName(),e.getSalary()+1000,e.getAge(),e.getSex(),e.getArea());
            return emp;
        }).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test04(){
        String[] array = {"a,b,c,d","1,2,3,4"};
        List<String> list = Arrays.stream(array).flatMap(
                str -> {
                    String[] split = str.split(",");
                    Stream<String> stream = Arrays.stream(split);
                    return stream;
                }).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test07(){
        Optional<Integer> optional = empList.stream().map(emp -> emp.getSalary()).reduce(Integer::sum);
        System.out.println("工资总和为："+optional.get());
    }

    @Test
    public void test08(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,2,4,5,6,8,9,7,6,2);
        List<Integer> list1 = list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.println("能被2整除的数:"+list1);

        //找出能被2整除的数（去重） 去重后过滤 过滤后去重
        Set<Integer> set = list.stream().filter(i -> i%2 == 0).collect(Collectors.toSet());
        System.out.println("能被2整除且不重复的数："+set);

        Map<String,Emp> map = empList.stream()
                .filter(e -> e.getSalary() > 8000)
                .collect(
                        Collectors.toMap(
                                emp -> emp.getName(),emp -> emp
                        )
                );
        System.out.println(map);
    }

    //统计员工人数、平均工资、工资总额、最高工资
    @Test
    public void test09(){
        // 求总数
        Long count = empList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = empList.stream().collect(Collectors.averagingDouble(Emp::getSalary));
        // 求最高工资
        Optional<Integer> max = empList.stream().map(Emp::getSalary).collect(Collectors.maxBy(Integer::compareTo));
        // 求工资之和
        Integer sum = empList.stream().collect(Collectors.summingInt(Emp::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = empList.stream().collect(Collectors.summarizingDouble(Emp::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);
    }

    @Test
    public void test10(){
        Map<Boolean,List<Emp>> part = empList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() >8000));
        Map<String,List<Emp>> group = empList.stream().collect(Collectors.groupingBy(Emp::getSex));
        Map<String,Map<String,List<Emp>>> group2 = empList.stream().collect(Collectors.groupingBy(Emp::getSex,Collectors.groupingBy(Emp::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);

    }

}
