package homework.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/16
 */
public class ServerTest02 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10010);
        byte[] bytes = new byte[1024*8];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        System.out.println("数据接受完成");
        System.out.println("数据长度："+packet.getLength());
        String str = new String(bytes,0,packet.getLength());
        System.out.println(str);
    }
}
