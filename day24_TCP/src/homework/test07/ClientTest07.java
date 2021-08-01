package homework.test07;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ClientTest07 {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("请输入用户名和密码：name/pwssword");
            String user = new Scanner(System.in).nextLine();
            Socket client = new Socket("127.0.0.1",10020);
            OutputStream os = client.getOutputStream();
            PrintWriter bos = new PrintWriter(new OutputStreamWriter(os));

            bos.println(user);
            bos.flush();
//        client.shutdownOutput();//关闭输出流，告诉服务器输出完成

            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg = br.readLine();
            System.out.println(msg);

            bos.close();
            os.close();
            br.close();
            is.close();
            client.close();
        }
    }
}
