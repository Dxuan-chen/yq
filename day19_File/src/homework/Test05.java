package homework;

import java.io.File;
import java.io.IOException;

/**
 * 功能描述：检查C盘下是否存在文件a.txt,如果不存在则创建该文件。
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\");
        boolean flag = findFile(file);
        if(!flag){
            new File("C:\\a.txt").createNewFile();
        }
        System.out.println(flag?"c盘下存在文件a.txt":"c盘下不存在文件a.txt,已自动创建a.txt");;

    }

    private static boolean findFile(File file) {
        File[] files = file.listFiles(pathname -> pathname.isFile());
        if(files != null && files.length > 0){
            for (File file1 : files) {
                if("a.txt".equals(file1.getName())){
                    return true;
                }
            }
        }


        File[] files2 = file.listFiles(pathname -> pathname.isDirectory());
        if(files2 != null && files2.length > 0){
            for (File f : files2) {
                if(findFile(f) == true){
                    return true;
                }
            }
        }

        return false;
    }
}
