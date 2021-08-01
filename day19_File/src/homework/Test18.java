package homework;

import java.io.File;
import java.util.Scanner;

/**
 *
 */
public class Test18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查看的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        Long size = calculate(file);
        System.out.println("该文件夹大小为："+size+"字节");
    }

    private static Long calculate(File file) {
        File[] files = file.listFiles();
        Long size = 0L;
        for (File f : files) {
            if(f.isFile()){
                size += f.length();
            }else{
                calculate(f);
            }
        }
        return size;
    }
}
