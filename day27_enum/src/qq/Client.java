package qq;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket client = new Socket("127.0.0.1",10086);
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = br.readLine();
            System.out.println("服务器说："+msg);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
            pw.println(new Date()+" 你好服务器");


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
