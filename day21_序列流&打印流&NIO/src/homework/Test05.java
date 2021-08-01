package homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/13
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("a.txt");
        Files.copy(path,new FileOutputStream("b.txt"));

        FileReader fr = new FileReader("b.txt");
        int read = 0;
        while((read=fr.read())!=-1){
            System.out.print((char)read);
        }
        fr.close();
    }
}
