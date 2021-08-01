package homework;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/13
 */
public class Test03 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream("d.txt");
        System.setOut(printStream);
        System.out.println(new Scanner(System.in).nextLine());

    }
}
