package homework;

import java.io.*;
import java.util.HashMap;

/**
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File file = new File("b.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);


        String line = null;
        HashMap<Integer,String> map = new HashMap<>();
        while ((line=br.readLine())!=null){
            String[] strs = line.split("\\.");
            map.put(Integer.parseInt(strs[0]),strs[1]);
        }
        file.delete();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String strs2 = null;
        for(int i = 1;i <= map.size();i ++){
            strs2 = i+"."+map.get(i);
            bw.write(strs2);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
