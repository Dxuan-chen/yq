package homework.test06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ServerTest06 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10010);
        while(true) {
            Socket client = server.accept();

            new Thread(() -> {
                try {
                    InputStream is = client.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);

                    String fileName = UUID.randomUUID().toString() + ".exe";
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:" + File.separator + "java" + File.separator + fileName));

                    byte[] bytes = new byte[1024*8];
                    int len = 0;
                    while ((len = bis.read(bytes)) != -1) {
                        bos.write(bytes,0,len);
                        bos.flush();
                    }
                    OutputStream os = client.getOutputStream();
                    PrintStream printStream = new PrintStream(os);
                    printStream.println("文件上传成功");

                    printStream.close();
                    bos.close();
                    os.close();
                    bis.close();
                    is.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
