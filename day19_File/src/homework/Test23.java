package homework;

import java.io.*;
import java.util.Scanner;

/**
 *
 */
public class Test23 {
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
            fos.write(b[i]);
        }
        System.out.println("保存成功");
        fos.close();
    }
}
