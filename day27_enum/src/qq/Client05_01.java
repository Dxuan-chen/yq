package qq;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Client05_01 {
    public static void main(String[] args) {

        ObjectOutputStream oos = null;
        try {
            Socket client = new Socket("127.0.0.1", 10086);

            ObjectInputStream bis = new ObjectInputStream(client.getInputStream());
            Thread thread = new Thread(() -> {
                while (true) {//接受信息
                    Msg acceptMsg = null;
                    try {
                        acceptMsg = (Msg) bis.readObject();

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("来自" + acceptMsg.getDstIp() + ":" + acceptMsg.getMessage());
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true) {
                System.out.print("密聊：目标主机");
                String dstIp = new Scanner(System.in).nextLine();
                if ("exit".equals(dstIp)) {
                    break;
                }
                System.out.println("内容：");
                String message = new Scanner(System.in).nextLine();
                Msg msg = new Msg(client.getInetAddress() + "/" + client.getPort(), dstIp, message);
                //发送信息
                oos = new ObjectOutputStream(client.getOutputStream());
                oos.writeObject(msg);
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
