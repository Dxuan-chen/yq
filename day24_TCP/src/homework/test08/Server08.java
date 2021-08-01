package homework.test08;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述：编写一个TCP的服务端，可以接受多个客户端的连接，当接收到用户的连接请求以后，就要把一张图片传回给客户端。
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Server08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10030);
        while (true){
            new Thread(() -> {
                try{
                    Socket client = server.accept();
                    FileInputStream fr = new FileInputStream("D:\\java\\timg.jpg");
                    BufferedInputStream bis = new BufferedInputStream(fr);
                    OutputStream os = client.getOutputStream();
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    byte[] bytes = new byte[1024*8];
                    int len = 0;
                    while((len=bis.read(bytes))!=-1){
                        bos.write(bytes,0,len);
                        bos.flush();
                    }
//                    client.shutdownOutput();
                    bis.close();
                    fr.close();
                    bos.close();
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
