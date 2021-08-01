package homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class Test05 {
    public static void main(String[] args) {
        Student stus1 = new Student("小明",50);
        Student stus2 = new Student("小红",70);
        Student stus3 = new Student("小华",60);
        List<Student> list = new ArrayList<>();
        Collections.addAll(list,stus1,stus2,stus3);
        List<Student> list2 = list.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
        System.out.println(list2);

    }
}

class Student implements Comparable {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
