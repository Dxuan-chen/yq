package homework.test08;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Client08 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("是否下载？y是");
        while ("y".equals(sc.nextLine())){
            Socket client = new Socket("127.0.0.1",10030);
            String path = "D:\\java\\"+UUID.randomUUID()+".jpg";
            InputStream is = client.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream fos = new FileOutputStream(path);
            byte[] bytes = new byte[1024*8];
            int len = 0;
            while((len=bis.read(bytes))!=-1){
                fos.write(bytes,0,len);
                fos.flush();
            }
            bis.close();
            is.close();
            fos.close();
            client.close();
            System.out.println("是否下载？y是");
        }
    }
}
