package homework;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 */
public class test15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = sc.nextLine();
        LinkedHashSet<Character> sets = new LinkedHashSet<>();
        char[] chars = input.toCharArray();
        for(char c:chars){
            sets.add(c);
        }
        for (Character set : sets) {
            System.out.println(set);
        }
    }
}
