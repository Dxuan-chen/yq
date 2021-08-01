package homework;

import java.io.*;
import java.util.Scanner;

/**
 *
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("源路径：");
        String path = sc.nextLine();
        System.out.println("目的路径：");
        String path2 = sc.nextLine();
        File file = new File(path);

        copyFiles(file,path2);

    }

    private static void copyFiles(File file,String path2) throws IOException {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                new File(path2+"\\"+f.getName()).mkdir();
                copyFiles(f,path2+"\\"+f.getName());
            }else{//拷贝文件
                FileReader fr = new FileReader(f);
                FileWriter fw = new FileWriter(path2);
                char[] chars = new char[1024];
                int len = 0;
                while((len=fr.read(chars))!=-1){
                    fw.write(chars,0,len);
                }
                fw.close();
                fr.close();
            }
        }
    }
}
