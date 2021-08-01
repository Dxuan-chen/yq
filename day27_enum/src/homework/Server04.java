package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Server04 {
    List<PrintWriter> writers = new ArrayList<>();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(10086);
            Server04 server_2 = new Server04();
            ExecutorService threadPool = Executors.newFixedThreadPool(3);
            while (true){
                Socket client = server.accept();
                System.out.println("客户端"+client.getInetAddress().getHostName()+"连接到服务器");
                ServerRunner_4 runner = server_2.new ServerRunner_4(client);

                threadPool.submit(runner);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private class ServerRunner_4 implements Runnable{
        private Socket client;

        public ServerRunner_4(Socket client) {
            this.client = client;
        }

        public ServerRunner_4() {
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            BufferedReader br = null;
            InetAddress inetAddress = client.getInetAddress();
            String clientStr="客户端："+inetAddress.getHostName()+"端口："+client.getPort()+"@";
            System.out.println(clientStr);
            try{
                pw = new PrintWriter(client.getOutputStream(),true);
                lock.lock();
                writers.add(pw);
                lock.unlock();
                pw.println(new Date());
                pw.println("你好客户端");
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg;
                while (true){
                    msg = br.readLine();
                    if("exit".equals(msg)){
                        break;
                    }
                    System.out.println(clientStr+msg);
                }

                lock.lock();
                for (PrintWriter writer : writers) {
                    writer.println(msg);
                }
                lock.unlock();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    lock.unlock();
                    writers.remove(pw);
                    lock.unlock();
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
