package homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Test06 {
    public static void main(String[] args) throws IOException {
//        System.out.println("文件路径");
//        String path = new Scanner(System.in).nextLine();
        FileReader fr = new FileReader("score.txt");
        FileWriter fw = new FileWriter("score.txt");
        Properties properties  = new Properties();
        properties.load(fr);
        char[] chars = new char[1024];
        int len = 0;

        if(properties.get("lisi")!=null){
            properties.setProperty("lisi","100");
        }
//        properties.store(fw);
        fw.close();
        fr.close();
    }
}
