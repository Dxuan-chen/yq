package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 功能描述：利用字节输出流一次写一个字节数组的方式向C盘的b.txt文件输出内容。
 */
public class Test24 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要保存的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        System.out.println("请输入要保存的内容：");
        String str = sc.nextLine();
        byte[] b = str.getBytes();
        for(int i = 0;i < b.length;i ++){
            byte[] b2 = {b[i]};
            fos.write(b2,0,1);
        }
        System.out.println("保存成功");
        fos.close();
    }

}
