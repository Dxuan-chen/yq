package tcp.cs01;

import java.io.*;
import java.net.Socket;

/**
 * 1.创建客户端Socket对象，指定连接的服务器的ip和端口
 * 2.发送数据
 * a.获取输出流对象，发送信息到服务器 outputstream
 * b.获取输入流对象，接受服务器发送的信息 inputstream
 */
public class Client01 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",6666);

        int port = client.getPort();
        System.out.println(port);

        OutputStream os = client.getOutputStream();
        PrintStream printStream = new PrintStream(os);
        printStream.println("你好服务器，我是客户端");

        InputStream is = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg = br.readLine();
        System.out.println(msg);

        br.close();
        is.close();
        printStream.close();
        os.close();
        client.close();
    }
}
