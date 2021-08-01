package homework;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class Test08 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\aaa\\b.txt");
        file.createNewFile();
        File file2 = new File("D:\\aaa\\b.txt");
        System.out.println("文件名："+file2.getName());
        System.out.println("文件大小："+file2.length());
        System.out.println("文件绝对路径："+file2.getAbsolutePath());
        System.out.println("父路径："+file2.getParent());

    }
}
