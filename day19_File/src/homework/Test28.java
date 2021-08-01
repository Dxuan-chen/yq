package homework;

import java.io.*;
import java.util.Scanner;

/**
 * 功能描述：利用字节流将C盘下的a.png图片复制到D盘下(文件名保存一致，一次读写一个字节的方式)
 */
public class Test28 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要复制的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File("D:\\aaaa.png"));
        int read = 0;
        while((read = fis.read()) !=- 1){
            fos.write((byte)read);
        }
        System.out.println("复制成功");
        fos.close();
        fis.close();
    }
}
