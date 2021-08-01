package file;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Parameter;

/**
 *
 */
public class Demo03 {
    @Test
    public void getDir(){
        printDir2(new File("D:\\Documents\\JAVA\\IDEA-Projects\\yueqian"));

    }


    public void printDir2(File dir){
        FileFilter filter = new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".java");
            }
        };
        File[] files = dir.listFiles(filter);
        for (File file : files) {
            if(file.isDirectory()){
                printDir2(file);
            }else{
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public void printDir3(File dir){
        File[] files = dir.listFiles(
                pathname -> pathname.isDirectory() || pathname.getName().endsWith(".java")
        );

        for (File file : files) {
            if(file.isDirectory()){
                printDir2(file);
            }else{
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
