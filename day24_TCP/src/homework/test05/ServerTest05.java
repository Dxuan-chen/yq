package homework.test05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ServerTest05 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6667);
        while(true) {
            Socket client = server.accept();
            new Thread(() -> {
                try {

                    InputStream is = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String str =br.readLine();
                    System.out.println(str);

                    OutputStream os = client.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                    bw.write("已收到\n");
//                    bw.newLine();
                    bw.flush();
                    bw.close();
                    os.close();
                    br.close();
                    is.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
