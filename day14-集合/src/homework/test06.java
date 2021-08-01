package homework;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 */
public class test06 {
    @Test
    public void test(){
        LinkedHashSet<String> sets = new LinkedHashSet<>();
        sets.add("王昭君");
        sets.add("王昭君");
        sets.add("西施");
        sets.add("杨玉环");
        sets.add("貂蝉");
        Iterator it = sets.iterator();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }
        System.out.println("-------------");
        for (String set : sets) {
            System.out.println(set);
        }

    }
}
