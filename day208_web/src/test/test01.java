package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/8/14
 */
public class test01 {

    private final static int PORT = 8080;

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("服务端应用已经启动");
            while(true){
                Socket socket = serverSocket.accept();
                doService(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doService(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            Thread.sleep(500);
            int size = inputStream.available();
            byte[] readBuf = new byte[size];
            inputStream.read(readBuf);
            String request = new String(readBuf,0,size);

            /*解析HTTP请求*/
            //获得HTTP请求的第一行
            int endIndex = request.indexOf("\r\n");
            if(endIndex == -1){
                endIndex = request.length();
            }

            //GET /root/hello.html HTTP/1.1
            String firstLineOfRequest = request.substring(0,endIndex);

            String[] parts = firstLineOfRequest.split(" ");
            String uri = "";
            if(parts.length>=2){
                uri = parts[1];
                System.out.println("uri="+uri);
            }

            if(uri.contains("favicon.ico")){
                return;
            }

            String responseFirstLine = "HTTP/1.1 200 OK\r\n";

            String contentType;
            if(uri.contains("html")||uri.contains("htm")){
                contentType = "text/html";
            }else if(uri.contains("jpg")||uri.contains("jpeg")){
                contentType = "image/jpeg";
            }else if(uri.contains("gif")){
                contentType = "image/gif";
            }else {//
                contentType = "application/octet-stream";
            }
            String responseHeader = "Content-Type:"+contentType+"\r\n\r\n";

            InputStream in= test01.class.getResourceAsStream("root/"+uri);

//        System.out.println("读取目标文件的长度="+in.available());

            //将组装好的http响应数据写回到客户端（浏览器）
            OutputStream outputStream=socket.getOutputStream();
            //写http响应数据的状态行
            outputStream.write(responseFirstLine.getBytes());
            //写http响应头数据
            outputStream.write(responseHeader.getBytes());

            int readLen=-1;
            byte[] buf=new byte[128];
            while ((readLen=in.read(buf))!=-1)
            {
                //写http响应的正文内容
                outputStream.write(buf,0,readLen);
            }

            Thread.sleep(1000);
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
