package homework;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
public class test04 {
    @Test
    public void test(){
        HashSet<String> sets = new HashSet<>();
        System.out.println("1."+sets);
        sets.add("zhangsan");
        sets.add("lisi");
        sets.add("wangwu1");
        sets.add("zhangsan");
        System.out.println("2."+sets);

        Iterator it = sets.iterator();
        System.out.println("3.");
        while(it.hasNext()){
            String next = (String)it.next();
            System.out.println(next);
        }

    }
}
