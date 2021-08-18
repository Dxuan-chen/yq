package homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 此HttpServer既支持静态资源、也支持动态资源
* */
public class HttpServerStatic {

    private static int PORT=8080;

    public static void main(String[] args) {

        //建立tcp/ip的服务端
        try {
            ServerSocket serverSocket=new ServerSocket(PORT);
            System.out.println("服务端应用已经启动");
            while (true)
            {
                //不断侦听客户端的连接
                Socket socket=serverSocket.accept();
                doService(socket);
            }

        } catch (IOException | InterruptedException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void doService(Socket socket) throws IOException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //获取http请求的输入流对象
        InputStream inputStream=socket.getInputStream();
        //等待耗时处理
        Thread.sleep(500);
        //请求内容的数据长度
        int size=inputStream.available();
        byte[] readBuf =new byte[size];
        inputStream.read(readBuf);
        String request=new String(readBuf,0,size);

        /*解析HTTP请求*/
        //获得HTTP请求的第一行
        int endIndex=request.indexOf("\r\n");
        if(endIndex==-1)
            endIndex=request.length();

        //GET /root/hello.html HTTP/1.1
        String firstLineOfRequest=request.substring(0,endIndex);
        //解释http请求协议第一行内容的数据，将数组分解到数组
        String []parts=firstLineOfRequest.split(" ");

        String uri="";
        if(parts.length>=2)
            uri=parts[1]; //获得HTTP请求中的uri
        System.out.println("uri="+uri);

        if(uri.contains("favicon.ico"))
        {
            return;
        }

        //如果客户端访问是servlet动态资源
        if(uri.contains("servlet")){
            // http://xxx:8080/servlet/HelloServlet?username=tom
            //获取客户端访问servlet类的类名
            //获得Servlet的名字
            String servletName=null;
            if(uri.contains("?"))
                // http://xxx:8080/servlet/HelloServlet?username=tom
                servletName=uri.substring(uri.indexOf("servlet/")+8,uri.indexOf("?"));
            else
                //  http://xxx:8080/servlet/HelloServlet
                servletName=uri.substring(uri.indexOf("servlet/")+8,uri.length());

            MyServlet servlet=(MyServlet)Class.forName("server."+servletName).getDeclaredConstructor().newInstance();
            servlet.init();//先调用Servlet对象的init()方法

            //调用Servlet的service()方法
            servlet.service(readBuf,socket.getOutputStream());

            Thread.sleep(1000);  //睡眠1秒，等待客户接收HTTP响应结果
            socket.close(); //关闭TCP连接
            return;

        }


        /*创建HTTP响应结果 */
        //HTTP响应的第一行
        String responseFirstLine="HTTP/1.1 200 OK\r\n";

        //HTTP响应头
        /*决定HTTP响应正文的类型，此处作了简化处理*/
        String contentType;
        if(uri.indexOf("html")!=-1 || uri.indexOf("htm")!=-1)
            contentType="text/html";
        else if(uri.indexOf("jpg")!=-1 || uri.indexOf("jpeg")!=-1)
            contentType="image/jpeg";
        else if(uri.indexOf("gif")!=-1)
            contentType="image/gif";
        else
            contentType="application/octet-stream";  //字节流类型

        String responseHeader="Content-Type:"+contentType+"\r\n\r\n";

        InputStream in= HttpServerStatic.class.getResourceAsStream("root/"+uri);

//        System.out.println("读取目标文件的长度="+in.available());

        //将组装好的http响应数据写回到客户端（浏览器）
        OutputStream outputStream=socket.getOutputStream();
        //写http响应数据的状态行
        outputStream.write(responseFirstLine.getBytes());
        //写http响应头数据
        outputStream.write(responseHeader.getBytes());

        int readLen=-1;
        byte buf[]=new byte[128];
        while ((readLen=in.read(buf))!=-1)
        {
            //写http响应的正文内容
            outputStream.write(buf,0,readLen);
        }

        Thread.sleep(1000);
        socket.close();


    }
}
