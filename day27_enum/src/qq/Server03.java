package qq;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Server03 {
    List<PrintWriter> writers = new ArrayList<PrintWriter>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(10086);
            Server03 server02 = new Server03();
            while (true){
                Socket client = server.accept();
                System.out.println("客户端说："+client.getInetAddress().getHostAddress()+"连接到服务器");
                ServerRunner_3 runner = server02.new ServerRunner_3(client);
                new Thread(runner).start();
            }
//            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
//            pw.println(new Date());
//            pw.println("你好客户端");
//            while(true) {
//                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                String msg = br.readLine();
//            }

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


    private class ServerRunner_3 implements Runnable {
        Socket client = null;

        public ServerRunner_3(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            BufferedReader br = null;
            InetAddress inetAddress = client.getInetAddress();
            String clientStr = "客户端："+inetAddress.getHostName()+"端口："+client.getPort();

            try{
                pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
                writers.add(pw);
                pw.println(new Date());
                pw.println("你好客户端");
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg = null;
                while (true) {
                    msg = br.readLine();
                    if ("exit".equals(msg)) {
                        break;
                    }
                    for (PrintWriter writer : writers) {
                        System.out.println(clientStr + msg);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    writers.remove(pw);
                    br.close();
                    pw.close();
                    System.out.println(clientStr+"退出连接");
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
