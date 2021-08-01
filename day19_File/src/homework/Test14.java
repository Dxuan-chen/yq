package homework;

import java.io.File;
import java.util.Scanner;

/**
 * 键盘录入一个文件路径，根据文件路径创建文件对象，判断是文件还是文件夹
 */
public class Test14 {
    static Long sumFiles = 0L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File file = new File(path);
        if(file.isFile()){
            System.out.println("该文件大小为："+file.length());
        }else if(file.isDirectory()){

            getFiles(file);
            System.out.println("该文件夹下的所有文件大小之和为："+sumFiles);
        }

    }

    private static Long getFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                sumFiles += getFiles(f);
            }else{
                sumFiles += f.length();
            }
        }
        return sumFiles;
    }
}
