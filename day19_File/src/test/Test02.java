package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        char[] chars2 = new char[chars.length];
        int j=0;
        int count = 0;
        for(int i=0;i<chars.length;i++){
            boolean flag = false;
            for(j=0;j < count;j++){
                if(chars[i]==chars2[j]){
                    flag = true;
                    break;
                }
            }
            if(flag == false){

                chars2[count] = chars[i];
                ++count;
            }
        }

        System.out.println(chars2);
    }
}
