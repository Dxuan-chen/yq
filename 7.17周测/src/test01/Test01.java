package test01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("student_info.txt"));
        HashSet<Student> set = new HashSet<>();
        String strs = null;
        while((strs=br.readLine())!=null){
            String name = strs.split("-")[0];
            int age = Integer.parseInt(strs.split("-")[1]);
            int score = Integer.parseInt(strs.split("-")[2]);
            set.add(new Student(name,age,score));
        }
        List list = set.stream().sorted(Comparator.comparing(Student::getScore).thenComparing(Student::getAge).reversed()).collect(Collectors.toList());
//        System.out.println(list);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
