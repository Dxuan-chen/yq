import org.junit.Test;

import java.io.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/12
 */
public class Demo01 {

    @Test
    public void test01() throws IOException {
        FileWriter fileWriter = new FileWriter("homework/a.txt");

        String str = "文件字符输出流";
        fileWriter.write(str.toCharArray());
        fileWriter.write(str);
        fileWriter.write("\n");
        fileWriter.flush();//刷新缓冲区域中的数据，写出到硬盘
        fileWriter.close();
    }

    @Test
    public void test02() throws IOException {
        FileWriter fileWriter = new FileWriter("homework/a.txt",true);
        String str = "我是语句1";
        fileWriter.write(str);
//        fileWriter.close();
        fileWriter.flush();
        fileWriter.close();
//        writer()将数据写到缓冲区中，
//         需要用flush()刷新缓冲区，将数据保存到文件中，
//         close()也可以将数据保存到文件中，但流对象不可以再使用。后面无法继续写数据。
    }

    @Test
    public void test03() throws IOException {
        FileReader fileReader = new FileReader("homework/a.txt");

        int read = fileReader.read();
        System.out.println((char) read);

        char[] chars = new char[10];
        int index = 0;

        while ((index = fileReader.read(chars))!=-1){
            String str = new String(chars,0,index);
            System.out.println(str);
        }
    }
}
