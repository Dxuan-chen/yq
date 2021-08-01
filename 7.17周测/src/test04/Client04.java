package test04;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/17
 */
public class Client04 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = null;
        while (!"over".equals(input=sc.nextLine())){
            Socket client = new Socket("127.0.0.1",10010);
            OutputStream os = client.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            pw.println(input);
            pw.flush();
            System.out.println(br.readLine());
            pw.close();
            os.close();
            br.close();
            is.close();
            client.close();
        }
    }
}
