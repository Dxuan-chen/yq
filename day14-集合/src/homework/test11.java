package homework;


import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 */
public class test11 {
    public static void main(String[] args){
        String[] strs = new String[]{"12345","67891","12347809933","98765432102","67891","12347809933"};
        LinkedList<String> lists = new LinkedList<>();
        for (int i = 0 ;i < strs.length;i ++) {
            if(!lists.contains(strs[i])){
                lists.add(strs[i]);
            }
        }
        for (String list : lists) {
            System.out.println(list);
        }
        System.out.println("----------");
        Iterator it = lists.iterator();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }

    }

}
