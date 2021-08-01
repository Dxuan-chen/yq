package homework;

import java.io.*;

/**
 *
 */
public class Test12 {
    public static void main(String[] args) throws IOException {
        String str = "我爱Java";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"),"gbk");
        osw.write(str);
        osw.close();
    }
}
