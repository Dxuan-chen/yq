package homework;

import homework.test02.Person;
import org.junit.Test;

import java.util.HashSet;

/**
 *
 */
public class test05 {
    @Test
    public void test(){
        HashSet<Person> sets = new HashSet<>();
        Person per = new Person("小明",20);
        Person per02 = new Person("小红",21);
        Person per03 = new Person("小华",19);
        sets.add(per);
        sets.add(per02);
        sets.add(per03);
        for (Person set : sets) {
            System.out.println(set);
        }

    }
}
