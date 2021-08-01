package Buffered;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/12
 */
public class BufferedDemo04 {
    @Test
    public void test01() throws IOException {
        FileOutputStream fos = new FileOutputStream("buffer.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("我是字节缓冲流".getBytes());
        bos.close();
    }

    @Test
    public void test02(){

        try(FileInputStream fis = new FileInputStream("buffer.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);){
            int index = 0;
            byte[] bytes = new byte[8*1024];
            while((index=bis.read(bytes))!=-1){
                String s = new String(bytes,0,index);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() throws IOException {
        long start = System.currentTimeMillis();
        FileOutputStream fos = new FileOutputStream("buffer2.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        FileInputStream fis = new FileInputStream("buffer.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);

        //index:存储读取的字节数据
        int index = 0;
        while((index=bis.read())!=-1) {
            bos.write(index);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+(end-start));
        bos.close();
        bis.close();

    }

    @Test
    public void test04() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(""));
        BufferedWriter bw = new BufferedWriter(new FileWriter(""));
        String line = null;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

}
