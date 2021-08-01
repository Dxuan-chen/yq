package homework.test18;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
public class test18 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();
        hs.add(new Student("aa",18,80));
        hs.add(new Student("bb",22,90));
        hs.add(new Student("cc",19,70));
        hs.add(new Student("dd",20,80));
        hs.add(new Student("ee",19,100));
        Iterator it = hs.iterator();
        Student stu = (Student)it.next();
        System.out.println(stu);
        int sum = 0;
        int high = stu.getScore();
        int low = stu.getScore();

        for (Student h : hs) {
           sum += h.getScore();
           if(high < h.getScore()){
               high = h.getScore();
           }
            if(low > h.getScore()){
                low = h.getScore();
            }
        }
        int avg = sum/hs.size();

        System.out.println("总分:"+sum);
        System.out.println("平均分:"+avg);
        System.out.println("最高分:"+high);
        System.out.println("最低分:"+low);

    }
}
