package homework;

import java.io.File;

/**
 * 功能描述：创建两个文件对象，分别使用相对路径和绝对路径创建。
 */
public class Test04 {
    public static void main(String[] args) {
        File file1 = new File("D://aaa.txt");
        File file2 = new File("D:","bbb.txt");
    }
}
