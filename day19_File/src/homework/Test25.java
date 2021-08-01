package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 功能描述：利用字节输出流对象往C盘下c.txt文件输出5句:"i love java"
 * 利用字节输出流对象往C盘下c.txt文件输出5句：“我爱Java”
 */
public class Test25 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要保存的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file,true);
        int len = 0;
        while(true){
            System.out.println("请输入要保存的内容：");
            String strs = sc.nextLine();
            byte[] b = strs.getBytes();
            fos.write(b);
            fos.write("\r\n".getBytes());
            System.out.println("保存成功");
        }

    }
}
