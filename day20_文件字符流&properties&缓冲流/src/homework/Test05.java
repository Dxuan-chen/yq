package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 *
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要统计的字符：");
        char c = sc.nextLine().charAt(0);
        System.out.println("出现次数："+counts(c));
    }

    private static int counts(char c) throws IOException {
        int count = 0;
        FileReader fr = new FileReader(new File("test.txt"));
        char[] chars = new char[1];
        int len = 0;
        while((len=fr.read(chars))!=-1){
            if(chars[0]==c){
                count++;
            }
        }
        fr.close();
        return count;
    }
}
