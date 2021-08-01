package qq;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Server02 {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(10086);
            Socket client = server.accept();
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            pw.println(new Date());
            pw.println("你好客户端");
            while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg = br.readLine();
                System.out.println("客户端说：" + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static class ServerRunnable implements Runnable {
        Socket client = null;

        public ServerRunnable(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            BufferedReader br = null;
            try{
                pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
                pw.println(new Date());
                pw.println("你好客户端");
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg = null;
                while (true){
                    if("exit".equals(msg)){
                        break;
                    }
                    msg = br.readLine();
                    System.out.println("客户端说："+msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    br.close();
                    pw.close();
                    InetAddress inetAddress = client.getInetAddress();
                    System.out.println("客户端："+inetAddress.getHostName()+"端口："+client.getPort()+"退出连接");

                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
