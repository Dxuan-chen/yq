package qq;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        try{
            server = new ServerSocket(10086);
            Socket client = server.accept();
            PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
            pw.println(new Date() +" 你好客户端" );
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = br.readLine();
            System.out.println("客户端说："+msg);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
