package test.test01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 功能描述：某班有 40 个学生，学号为 180201-180240，
 * 全部参加 Java 集合阶段检测，给出所有同学的成绩 （可随机产生，范围为 50-100），
 * 请编写程序将本班 各位同学成绩从高往低排序打印输出,成绩相同时学号较小的优先打印
 */
public class Test {
    public static void main(String[] args) {

        List<Student> list = initData();
        //使用Collections的排序方法实现排序
        List<Student> list3 = studentSort2(list);
        //使用stream流的sort排序方法实现排序
        List<Student> list2 = studentSort(list);

        System.out.println("-------------使用Collections的排序方法实现排序-------------");
        print(list2);
        System.out.println("-------------使用stream流的sort排序方法实现排序-------------");
        print(list3);
    }

    private static List studentSort2(List<Student> list) {
        List<Student> list2 = list.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
        return list2;
    }

    private static void print(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    private static List studentSort(List<Student> list) {
        Collections.sort(list,(e1,e2)->e2.getScore() - e1.getScore());
        return list;
    }

    private static List initData() {
        ArrayList<Student> students = new ArrayList<>();
        int name = 10;
        int number = 180201;
        Random ran = new Random();
        for(int i = 0;i< 40;i ++){
            students.add(new Student("同学 "+(name++),String.valueOf(number++),ran.nextInt(51)+50));
        }
        return students;
    }
}
