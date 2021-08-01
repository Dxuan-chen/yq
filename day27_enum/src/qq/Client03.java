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
public class Client03 {
    public static void main(String[] args) {
        try{
            Socket client = new Socket("127.0.0.1",10086);
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = null;
            msg = br.readLine();
            System.out.println("服务器说："+msg);
            msg = br.readLine();
            System.out.println("服务器说："+msg);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
            pw.println(new Date());
            pw.println("你好服务器");
            Thread thread = new Thread(() -> {
                while (true){//接受信息
                    String acceptMsg = null;
                    try{
                        acceptMsg = br.readLine();

                    } catch (IOException e) {
                        //如果客户端主线程结束了，CPU仍然会再执行一段守护线程，br因为已经关闭就会出现socket关闭异常
                        e.printStackTrace();
                    }
                    System.out.println(acceptMsg);
                }
            });
            thread.setDaemon(true);
            thread.start();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                String line = sc.nextLine();
                pw.println(line);
                if("exit".equals(line)){
                    break;
                }

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
