package homework;

import java.io.*;
import java.util.Scanner;

/**
 * 功能描述：用字节流将C盘下的a.png图片复制到D盘下(文件名保存一致，一次读写一个字节数组的方式进行复制)
 */
public class Test29 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要复制的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File("D:\\aaaa.png"));
        byte[] bytes = new byte[1];
        int len = 0;
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        System.out.println("复制成功");
        fos.close();
        fis.close();
    }
}
