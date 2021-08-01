package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Test13 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"gbk");
        String line = null;
        char[] chars = new char[1024];
        int read = 0;
        while((read=isr.read())!=-1){

            System.out.print((char)read);
        }
        isr.close();
    }
}
