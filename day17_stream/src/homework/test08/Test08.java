package homework.test08;

import homework.test02.Emp;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Test08 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7000, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        //从员工集合中筛选出salary大于8500的员工，并放置到新的集合里
        List<Person> list1 = personList.stream().filter(e -> e.getSalary() > 8500).collect(Collectors.toList());
        Optional low = personList.stream().map(e -> e.getSalary()).collect(Collectors.minBy(Integer::compareTo));
        Double avg = personList.stream().collect(Collectors.averagingInt(Person::getSalary));
        Optional<Integer> sum = personList.stream().map(e -> e.getSalary()).reduce(Integer::sum);

        System.out.println(low.get());
        System.out.println(avg);
        System.out.println(sum.get());
        List<Person> list2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println(list2);

        Map<String,List<Person>> map = personList.stream().collect(Collectors.groupingBy(Person::getArea));
        Set<String> keySet = map.keySet();
        System.out.println("-----------地区分类----------");
        for (String s : keySet) {
            System.out.println(s+":"+map.get(s));
        }

        Map<String,Map<String,List<Person>>> map2 = personList.stream().collect(Collectors.groupingBy(Person::getSex,Collectors.groupingBy(Person::getArea)));
        System.out.println("-----------性别、地区分类----------");
        Set<String> keySet1 = map2.keySet();
        for (String s1 : keySet1) {
            System.out.println(s1+":");
            for (String s2 : map2.get(s1).keySet()) {
                System.out.println(s2+":"+map2.get(s1).get(s2));
            }
        }

        System.out.println("-----------是否高于8500----------");
        Map<Boolean,List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary()>8500));
        System.out.println(part);



    }
}
