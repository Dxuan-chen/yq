package web.test;

import java.io.OutputStream;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/8/16
 */
public class UploadServlet implements MyServlet {
    @Override
    public void init() {
        System.out.println("UploadServlet is inited");
    }

    @Override
    public void service(byte[] requestBuffer, OutputStream out) {
        String request = new String(requestBuffer);

        System.out.println(request);

        //
    }
}
