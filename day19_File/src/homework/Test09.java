package homework;

import java.io.File;
import java.util.Scanner;

/**
 *
 */
public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path1 = sc.nextLine();
        String path2 = sc.nextLine();
        File file1 = new File(path1);
        File file2 = new File(path2);
        System.out.println(file1.isFile()?file1.getName()+"是一个文件":file1.getName()+"不是一个文件");
        System.out.println(file2.isDirectory()?file1.getName()+"是一个文件夹":file1.getName()+"不是一个文件夹");


    }
}
