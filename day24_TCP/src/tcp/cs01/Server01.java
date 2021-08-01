package tcp.cs01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器：
 * 1.创建服务器连接对象
 * 2.接受一个客户端连接
 * 3.开始通讯:
 * a.等待接口客户端发送信息 inputstream
 * b.发送数据给客户端 outputstream
 */
public class Server01 {
    public static void main(String[] args) throws IOException {
        //1.创建服务器连接对象
        ServerSocket server = new ServerSocket(65535);
        System.out.println("服务器启动，等待接受客户端连接");
        //2.接受一个客户端连接
        Socket client = server.accept();
        System.out.println("客户端连接成功");
        System.out.println(client.getInetAddress());
        //a.等待接口客户端发送信息 inputstream
        InputStream is = client.getInputStream();
        //构造缓冲字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String msg = reader.readLine();
        System.out.println(msg);
        //b.发送数据给客户端 outputstream
        OutputStream os = client.getOutputStream();
        PrintStream printStream = new PrintStream(os);
        printStream.println("你好客户端，我是服务器10086！");

        printStream.close();
        os.close();
        reader.close();
        is.close();
        client.close();
    }
}
