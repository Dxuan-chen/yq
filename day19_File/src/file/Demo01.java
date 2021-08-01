package file;



import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 */
public class Demo01 {

    @Test
    public void test01(){
        File file = new File("D:\\Documents\\JAVA\\IDEA-Projects\\yueqian\\day19_File\\day19_File.iml");
        System.out.println(file);
        System.out.println("文件绝对路径："+file.getAbsolutePath());

        File file2 = new File("yueqian_day19.iml");
        System.out.println("文件绝对路径："+file2.getAbsolutePath());
        System.out.println("相对路径："+file2.getPath());

        String parenPath = "D:\\Documents\\JAVA\\IDEA-Projects\\yueqian\\day19_File";
        File file3 = new File(parenPath,"day19_File.iml");
        System.out.println("file3   文件绝对路径："+file3.getAbsolutePath());

        File parenFile = new File("D:\\Documents\\JAVA\\IDEA-Projects\\yueqian\\day19_File");
        File file4 = new File(parenFile,"day19_File.iml");
        System.out.println("file4   文件绝对路径："+file4.getAbsolutePath());
    }

    @Test
    public void test02(){
        File parenFile = new File("D:\\Documents\\JAVA\\IDEA-Projects\\yueqian\\day19_File");
        File file = new File(parenFile,"day19_File.iml");
        System.out.println("获取父路径："+file.getParent());
        long l = file.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("文件最后修改时间："+sdf.format(new Date(l)));
    }

    @Test
    public void test03(){
        File file = new File("D:\\Documents\\JAVA\\IDEA-Projects\\yueqian");
        String[] list = file.list();
        System.out.println(Arrays.toString(list));

        File[] list2 = file.listFiles();
        System.out.println(Arrays.toString(list2));
    }

    @Test
    public void test04(){
        File file = new File("day19_File.iml");
        File dir = new File("D:\\Documents\\JAVA\\IDEA-Projects\\yueqian");
        System.out.println(file.exists());
        System.out.println(dir.exists());

        System.out.println(file.isFile());
        System.out.println(dir.isFile());

        System.out.println(file.isDirectory());
        System.out.println(dir.isDirectory());

    }

    @Test
    public void test05() throws IOException {
        File file = new File("abc.java");

        System.out.println("文件是否创建:"+file.createNewFile());

        boolean delete = file.delete();
        System.out.println("删除文件:"+delete);
    }

    @Test
    public void test06(){
        File dir = new File("D:\\aaa\\test");
        System.out.println("文件夹创建:"+dir.mkdir());
        System.out.println("文件夹和父文件夹创建"+dir.mkdirs());

        File demoDir = new File("D:\\aaa");
        System.out.println("删除文件夹:"+demoDir.delete());//文件夹中有内容，不能直接删除文件夹
        System.out.println("删除文件夹:"+dir.delete());
        System.out.println("删除文件夹:"+demoDir.delete());

    }

}
