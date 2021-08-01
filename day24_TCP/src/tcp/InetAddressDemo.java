package tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println("主机的名字: "+ localHost.getHostAddress());
        System.out.println("主机的IP  : "+localHost.getHostName());

        System.out.println(localHost);
        String[] strs = localHost.toString().split("/");
        System.out.println(strs[0]);

        InetAddress host = InetAddress.getByName("192.168.74.20");
        System.out.println(host.getHostAddress());
    }
}
