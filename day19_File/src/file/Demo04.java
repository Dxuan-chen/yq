package file;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class Demo04 {
    @Test
    public void test01(){
        String fileName = "d:" + File.separator + "Demo" + File.separator + "a.txt";

        File file = new File(fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file,true);

            fos.write(65);
            fos.write(66);
            fos.write(67);
            fos.write(68);
//            fos.write(128);
            String str = "IO流操作";
            byte[] bytes = str.getBytes("gbk");
            System.out.println(Arrays.toString(bytes));
            fos.write(bytes);
            fos.write(bytes,2,6);
            fos.write("\r\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件找不到");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭操作异常");
            }
        }
    }

    @Test
    public void test02() throws IOException {
        String fileName = "d:" + File.separator + "Demo" + File.separator + "a.txt";

        FileInputStream fis = new FileInputStream(fileName);
        int read = -1;
        while((read = fis.read()) != -1){
            System.out.println("读取到的数据"+read);
        }
    }

    @Test
    public void test03() throws IOException {
        String fileName = "d:" + File.separator + "Demo" + File.separator + "a.txt";
        FileInputStream fis = new FileInputStream(fileName);

        byte[] b = new byte[2];
        int len = 0;
        //返回读取到的字节数len
        while((len = fis.read(b)) != -1){
            System.out.println(Arrays.toString(b));
            String str = new String(b,0,len,"gbk");
            System.out.println(str);
        }
        fis.close();
    }

    @Test
    public void test04() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("");

    }
}
