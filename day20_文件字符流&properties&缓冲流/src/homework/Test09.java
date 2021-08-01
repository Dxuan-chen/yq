package homework;

import java.io.*;

/**
 *
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        String str = "i love java";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\java\\e.txt"));

        bos.write(str.getBytes());
        bos.close();
    }
}
