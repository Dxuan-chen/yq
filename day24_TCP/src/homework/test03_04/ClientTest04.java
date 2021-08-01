package homework.test03_04;

import java.io.*;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ClientTest04 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6666);

        OutputStream os = client.getOutputStream();
        PrintStream printStream = new PrintStream(os);
        printStream.println("你好服务器，我是客户端");

        InputStream is = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = null;
        while((str=br.readLine())!=null){
            System.out.println(str);
        }

        printStream.close();
        os.close();
        br.close();
        is.close();
        client.close();
    }
}
