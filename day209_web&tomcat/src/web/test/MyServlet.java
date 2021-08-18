package web.test;

import java.io.OutputStream;

public interface MyServlet {

    //初始化
    public void init();
    //处理请求及响应的方法
    /*
    * 参数一：http请求协议内容
    * 参数二：输出流对象
    * */
    public void service(byte[] requestBuffer, OutputStream out);
}
