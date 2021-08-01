package tcp.cs02;

import java.io.*;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class Client03 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",2000);

        int port = client.getPort();
        System.out.println("端口号："+port);
        long start = System.currentTimeMillis();
        //读取文件
        FileInputStream fis = new FileInputStream("D:\\java\\XP_INSTALL181209.iso");
        byte[] bytes = new byte[1024*8];
        int len = 0;
        OutputStream os = client.getOutputStream();
        while((len=fis.read(bytes))!=-1){
            os.write(bytes);
//            os.flush();
        }
        client.shutdownOutput();//关闭输出流，告诉服务器输出完成
//        os.write("文件上传了".getBytes());
        InputStream is = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg = br.readLine();
        System.out.println(msg);
        long end = System.currentTimeMillis();
        long totalSeconds = (end-start)/1000;
        System.out.println("耗时："+totalSeconds+"s "+(end-start)%1000+"ms");

        br.close();
        is.close();
        os.close();
        client.close();
    }
}
