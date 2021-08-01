package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 功能描述：利用字节输入流读取C盘文件a.txt的内容，使用循环读取，一次读取一个字节，直到读取到文件末尾。将读取的字节输出到控制台
 */
public class Test26 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要读取的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        int read = 0;
        while((read = fis.read()) != -1){
            System.out.print((char)read);
        }
        fis.close();
    }
}
