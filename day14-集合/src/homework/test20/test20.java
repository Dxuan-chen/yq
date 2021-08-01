package homework.test20;

import java.util.HashSet;

/**
 *
 */
public class test20 {
    public static void main(String[] args){
        HashSet<Student> classes1 = new HashSet<>();
        classes1.add(new Student("张三",20));
        classes1.add(new Student("李四",22));
        classes1.add(new Student("王五",21));

        HashSet<Student> classes2 = new HashSet<>();
        classes2.add(new Student("小明",20));
        classes2.add(new Student("小红",22));

        HashSet<HashSet<Student>> subjects = new HashSet<>();
        subjects.add(classes1);
        subjects.add(classes2);

        for (HashSet<Student> subject : subjects) {
            System.out.println(subject);
        }
    }
}
