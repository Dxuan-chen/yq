package homework;

import java.io.File;
import java.util.Scanner;

/**
 * 功能描述：键盘录入一个文件夹路径，删除该路径下的文件夹(文件夹中包含有子文件夹)
 */
public class Test20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        System.out.println(delDirectory(file)?"删除成功":"删除失败");
    }

    private static boolean delDirectory(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                delDirectory(f);
                f.delete();
            }else{
                f.delete();
            }
        }
        return true;
    }
}
