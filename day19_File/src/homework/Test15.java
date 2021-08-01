package homework;

import java.io.File;
import java.util.Scanner;

/**
 * 功能描述：递归遍历将指定文件夹的所有文件(包括所有子文件夹的文件)的全路径输出在控制台。
 */
public class Test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要遍历的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        getFilesPath(file);
    }

    private static void getFilesPath(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                getFilesPath(f);
            }else {
                System.out.println(f.getAbsolutePath());
            }
        }

    }
}
