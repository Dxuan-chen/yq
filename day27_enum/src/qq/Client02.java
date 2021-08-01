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
public class Client02 {
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

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                String line = sc.nextLine();
                if("exit".equals(line)){
                    break;
                }
                pw.println(line);

            }
            client.shutdownOutput();
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
