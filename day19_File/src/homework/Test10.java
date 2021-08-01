package homework;

import java.io.File;

/**
 * 功能描述：获取指定文件夹下所有的文件，并将所有文件的名字输出到控制台
 */
public class Test10 {
    public static void main(String[] args) {
        File file = new File("D:\\VMware");
        getFile(file);


    }

    private static void getFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                getFile(f);
            }else{
                System.out.println(f.getName());
            }
        }
    }
}
