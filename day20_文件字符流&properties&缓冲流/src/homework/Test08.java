package homework;

import java.io.*;

/**
 *
 */
public class Test08 {

    public static void main(String[] args) throws IOException {
        String path = "D:\\testCF.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java\\d.txt"));
        char[] chars = new char[1];
        int len = 0;
        while((len=br.read(chars))!=-1){
            bw.write(chars,0,len);
        }
        bw.close();
    }

}
