package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Test14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        ArrayList<String> list = new ArrayList<>();
        String line = null;
        while((line=br.readLine())!=null){
            list.add(line);
        }
        Collections.reverse(list);
        BufferedWriter bw = new BufferedWriter(new FileWriter("text1.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}
