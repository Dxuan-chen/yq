package homework.test16;

import java.io.File;
import java.util.Scanner;

/**
 * 获得指定文件夹下所有的java文件(不考虑子文件夹的)并输出到控制台
 */
public class Test16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要遍历的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        JavaFilter javaFilter = new JavaFilter();
        File[] files = file.listFiles(javaFilter);
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
