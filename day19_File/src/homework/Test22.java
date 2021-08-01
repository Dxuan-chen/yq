package homework;

import java.io.File;
import java.util.Scanner;

/**
 * 功能描述：从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 */
public class Test22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要打印的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        printFiles(file);
    }

    private static void printFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
            if(f.isDirectory()){
                printFiles(f);
            }
        }

    }
}
