package test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Server04 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10010);
        while (true) {
            Socket client = server.accept();
            new Thread(() -> {
                try {

                    InputStream is = client.getInputStream();
                    OutputStream os = client.getOutputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

                    String read = br.readLine();
                    System.out.println(read);
                    pw.println(read.toUpperCase());
                    pw.flush();
                    br.close();
                    is.close();
                    pw.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
