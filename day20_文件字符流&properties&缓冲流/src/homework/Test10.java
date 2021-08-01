package homework;

import java.io.*;

/**
 *
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\java\\b.png"));
        byte[] bytes = new byte[1];
        int len = 0;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        System.out.println("拷贝成功");
    }
}
