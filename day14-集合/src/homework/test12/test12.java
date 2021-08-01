package homework.test12;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
public class test12 {
    public static void main(String[] args){
        HashSet<Student> sets = new HashSet<>();
        Student stu1 = new Student("aa",20,"female");
        Student stu2 = new Student("bb",21,"male");
        Student stu3 = new Student("cc",21,"male");
        Student stu4 = new Student("dd",19,"male");
        Student stu5 = new Student("ab",22,"female");
        Student stu6 = new Student("ac",20,"female");
        Student stu7 = new Student("ee",22,"male");
        Student stu8 = new Student("ff",23,"female");
        Student stu9 = new Student("bc",18,"female");
        Student stu10 = new Student("ad",22,"male");

        sets.add(stu1);
        sets.add(stu2);
        sets.add(stu3);
        sets.add(stu4);
        sets.add(stu5);
        sets.add(stu6);
        sets.add(stu7);
        sets.add(stu8);
        sets.add(stu9);
        sets.add(stu10);
        Iterator it = sets.iterator();
        while(it.hasNext()){
            System.out.println((Student)it.next());
        }
        System.out.println("-------------------");
        for(Student stu:sets){
            System.out.println(stu);
        }

    }

}
