import org.junit.Test;

import java.io.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/12
 */
public class Demo05 {

    //转换输入流
    @Test
    public void test02() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(""), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(""), "UTF-8");

        char[] chars = new char[1024];
        int index=0;
        while((index=isr.read(chars))!=-1){
            String s = new String(chars);
            System.out.println(s);
            osw.write(s);
        }
        osw.close();
        isr.close();

    }
}
