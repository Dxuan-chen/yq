package homework;

import java.io.File;
import java.util.Scanner;

/**
 * 功能描述：键盘录入一个文件夹路径，删除该路径下的文件夹。(录入的文件夹里面要有多个文件，不能包含有子文件夹)
 */
public class Test17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            f.delete();
        }
        file.delete();
        System.out.println("删除成功");
    }
}
