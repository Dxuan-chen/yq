package homework;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;

public class HelloServlet implements MyServlet {

    @Override
    public void init() {
        System.out.println("HelloServlet 初始化处理");
    }

    /*
    * 针对客户端发送http请求作解释
    * 针对客户端作出结果响应
    * */
    @Override
    public void service(byte[] requestBuffer, OutputStream out) {

        //将字节数组的http请求内容转换成字符串输出
        String request=new String(requestBuffer);

        /*解析HTTP请求*/
        //获得HTTP请求的第一行
        int endIndex=request.indexOf("\r\n");
        if(endIndex==-1)
            endIndex=request.length();
        //GET /root/hello.html HTTP/1.1
        String firstLineOfRequest=request.substring(0,endIndex);
        //解释http请求协议第一行内容的数据，将数组分解到数组
        String []parts=firstLineOfRequest.split(" ");

        //定义一个用户名变量
        String username=null;
        //获取提交方法
        String method=parts[0];
        String uri=parts[1];
        // uri=/helloServlet?username=tom
        if(method.equalsIgnoreCase("get"))
        {
            String parameters=uri.substring(uri.indexOf("?"),uri.length());
            parts=parameters.split("=");
            username=parts[1];

        }else if(method.equalsIgnoreCase("post"))
        {

        }


        //组装http的响应数据格式
        /*创建HTTP响应结果 */
        //HTTP响应的第一行
        try {
            //默认url路径不支持中文，将url的中文解码为utf-8
            String userNameUtf8=URLDecoder.decode(username,"UTF-8");

            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            //发送HTTP响应头
            out.write("Content-Type:text/html;charset=utf-8\r\n\r\n".getBytes());
            //发送HTTP响应正文
            String content="<html><head><title>HelloWorld"
                    +"</title></head><body>";
            content+="<h1>Hello:"+userNameUtf8+"</h1></body><head>";
            out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

