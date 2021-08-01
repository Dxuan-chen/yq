package homework;

import java.io.File;

/**
 * 功能描述：在C盘下创建一个名为bbb的文件夹
 */
public class Test06 {
    public static void main(String[] args) {
        new File("C:\\ccc\\bbb\\aaa").mkdirs();

    }
}
