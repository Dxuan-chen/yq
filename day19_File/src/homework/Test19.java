package homework;


import java.io.File;
import java.util.Scanner;

/**
 * 功能描述：使用文件过滤器筛选将指定文件夹下的小于200K的小文件获取并打印(包括所有子文件夹的文件)
 */
public class Test19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查看的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        System.out.println("小于200K的文件有：");
        printFiles(file);
    }

    private static void printFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                printFiles(f);
            }else if(f.length() < 200*1024){
                System.out.println(f.getName());
            }
        }
    }
}
