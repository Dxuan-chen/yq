package print;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 */
public class Demo02 {

    @Test
    public void test01() throws FileNotFoundException {
        PrintStream out = System.out;

        //控制台输出
        out.println("打印字节流");

        //改变输出设置
        PrintStream printStream = new PrintStream("a.txt");
        System.setOut(printStream);
        System.out.println("打印到文件中");
    }

    @Test
    public void test02() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("b.txt","utf-8");
        writer.println("字符打印输出流");
        writer.println(12);
    }

}
