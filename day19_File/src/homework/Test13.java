package homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Test13 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        File file = new File(input);
        if(!file.exists()){
            file.createNewFile();
            System.out.println("文件创建成功");
        }else{
            System.out.println("文件大小："+file.length());;
        }

    }
}
