package lambda.lambda03;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Demo06Comparator {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("古力娜扎", 19),
                new Person("迪丽热巴", 18),
                new Person("马尔扎哈", 20)
        };
        //匿名内部类
        fun1(arr);

        //lambda
        fun2(arr);

    }

    //匿名内部类

    public static void fun1(Person[] arr){
        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(arr,comp);

        for (Person person : arr) {
            System.out.println(person);
        }
    }

    //lambda表达式
    private static void fun2(Person[] arr) {
        Arrays.sort(arr,(Person p1,Person p2) -> {
            return p1.getAge() - p2.getAge();
        }
        );

        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
