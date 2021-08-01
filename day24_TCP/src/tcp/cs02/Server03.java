package tcp.cs02;

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
public class Server03 {
    public static void main(String[] args) throws IOException {
        //1.服务器连接对象
        ServerSocket server = new ServerSocket(2000);
        while(true) {
            //2.接受客户端连接
            Socket client = server.accept();
            //每个客户端连接启动一个线程任务，解决多个客户端不能一起与服务器交互问题
            new Thread(() -> {

            try {
                InputStream is = client.getInputStream();
                BufferedInputStream inputStream = new BufferedInputStream(is);
                //文件输出流
                //随机生成文件名    /UUID生成
                String fileName = UUID.randomUUID().toString();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:" + File.separator + "java" + File.separator + fileName + ".txt"));

                byte[] bytes = new byte[1024 * 8];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }

                OutputStream outputStream = client.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.println("文件上传完成");

                printStream.close();
                outputStream.close();
                bos.close();
                inputStream.close();
                is.close();
                client.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            }).start();
        }
    }
}
