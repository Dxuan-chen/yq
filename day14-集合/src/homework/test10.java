package homework;


import java.util.HashSet;

/**
 *
 */
public class test10 {
    public static void main(String[] args){
        HashSet<String> sets = new HashSet<>();
        sets.add("张三");
        sets.add("李四");
        sets.add("王五");
        sets.add("二丫");
        sets.add("钱六");
        sets.add("孙七");
        System.out.println(sets);
        sets.remove("二丫");
        System.out.println(sets);
        sets.add("王小丫");
        System.out.println(sets);
    }
}
