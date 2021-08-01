package homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 *
 */
public class test14 {
    public static void main(String[] args){
        HashSet<Integer> hs = new HashSet<>();
        Random ran = new Random();
        while(hs.size()<10){
            int a = ran.nextInt(20)+1;
            hs.add(a);
        }
        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.println((Integer)it.next());
        }
    }
}
