package homework.test06;

import java.io.*;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ClientTest06 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",10010);

        OutputStream os = client.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        String path = "D:\\Download\\besttrace.exe";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] bytes = new byte[1024*8];
        int len = 0;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
            bos.flush();
        }
        client.shutdownOutput();//关闭输出流，告诉服务器输出完成

        InputStream is = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg = br.readLine();
        System.out.println(msg);

        bis.close();
        bos.close();
        os.close();
        br.close();
        is.close();
        client.close();
    }
}
