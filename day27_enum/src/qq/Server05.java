package qq;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
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
public class Server05 {
    Map<String,Socket> clients = new HashMap<>();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        try{
            while (true) {
                server = new ServerSocket(10030);

                client = server.accept();
                Server05 server05 = new Server05();
                ServerRunner runner = server05.new ServerRunner(client);
                threadPool.submit(runner);



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerRunner implements Runnable{
        private Socket client;

        public ServerRunner(Socket client) {
            this.client = client;
        }

        public ServerRunner() {
        }

        @Override
        public void run() {
            InputStream is = null;
            ObjectInputStream ois = null;
            Socket srcClient = null;
            ObjectOutputStream oos = null;
            try {
                is = client.getInputStream();
                lock.lock();
                clients.put(client.getInetAddress()+"/"+client.getPort(),client);
                lock.unlock();
                ois = new ObjectInputStream(is);
                Msg msg = (Msg) ois.readObject();
                System.out.println(msg);
                String srcIp = msg.getSrcIp();
                if((srcClient = clients.get(srcIp))!=null){
                    oos = new ObjectOutputStream(srcClient.getOutputStream());
                    oos.writeObject(msg);
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    oos.close();
                    ois.close();
                    is.close();
                    srcClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}
