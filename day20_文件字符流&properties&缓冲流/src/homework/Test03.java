package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/12
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream(new File("stu.txt"));
        String input = null;
        while(!"end".equals(input = sc.nextLine())){
            fos.write(input.getBytes());
            fos.write('\n');
        }
        fos.close();
    }
}
