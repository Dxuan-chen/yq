package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class FriendServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        while (true) {

            Socket client = server.accept();
            new Thread(() -> {
                try {
                    InputStream is = client.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String str = null;

                    str = br.readLine();    //GET /login.html HTTP/1.1

                    String[] split = str.split(" ");
                    System.out.println(Arrays.toString(split));
                    String path = split[1].substring(1);


                    //响应浏览器：  读取文件，通过输出流响应
                    OutputStream os = client.getOutputStream();
                    os.write("HTTP/1.1 200 OK\r\n".getBytes());
                    os.write("Content-Type:text/html\r\n".getBytes());
                    os.write("\r\n".getBytes());
                    //输入流读取第一个Path路径的文件，复制到os输出流
//        Files.copy(Path.of("day24/login.html"),os);
                    FileInputStream fis = new FileInputStream("day24_TCP&NIO/" + path);

                    byte[] bytes = new byte[1024 * 10];
                    int len = 0;
                    while ((len = fis.read(bytes)) != -1) {
                        os.write(bytes, 0, len);
                        os.flush();
                    }
//        os.close();
                    br.close();
                    isr.close();
                    is.close();
                    client.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
