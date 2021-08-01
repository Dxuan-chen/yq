package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Test27 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要读取的文件路径：");
        String path = sc.nextLine();
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1];
        int len = 0;
        while((len = fis.read(b)) != -1){
            System.out.print(new String(b));
        }
        fis.close();
    }
}
