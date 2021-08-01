package test;

import java.io.*;
import java.util.Scanner;

/**
 * 功能描述：从c盘剪切一个图片文件到d盘下
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要剪切的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File("D:\\bb.png"));

        int len = 0;
        byte[] b = new byte[1024];
        while((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        System.out.println("剪切成功");
    }
}
