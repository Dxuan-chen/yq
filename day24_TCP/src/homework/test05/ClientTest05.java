package homework.test05;

import java.io.*;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ClientTest05 {
    public static void main(String[] args) throws IOException {

        while(true) {
            Socket client = new Socket("127.0.0.1",6667);
            OutputStream os = client.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("你好服务器，我是客户端\n");
            bw.flush();

            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str =br.readLine();
            System.out.println(str);

            bw.close();
            os.close();
            br.close();
            is.close();
        }
    }
}
