package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream(new File("Info.txt"));
        String input = null;
        while (!"886".equals(input = sc.nextLine())){
            fos.write(input.getBytes());
            fos.write('\n');
        }
        fos.close();
    }
}
