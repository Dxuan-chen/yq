package homework;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/12
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String,File> map = new HashMap<>();
        copyFiles(new File(input),map);
        Set<String> keySet = map.keySet();
        String path = "D:/java";
        int count = 0;
        for (String key : keySet) {
            File file = new File(path+"\\"+key);
            file.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(map.get(key)));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line = null;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            String[] strs = key.split("\\.");
            if("java".equals(strs[strs.length-1])){
                count++;
            }
        }
        System.out.println("java文件有"+count+"个");

    }

    private static void copyFiles(File file,Map<String,File> map) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                copyFiles(f,map);
            }else{
                if(map.get(f.getName())!=null){
                    map.put(f.getName()+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),f);
                }else {
                    map.put(f.getName(),f);
                }
            }
        }
    }
}
