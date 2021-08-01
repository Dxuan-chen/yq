package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 功能描述：
 * 1.创建DatagramSocket 对象，接受信息
 * 2.DatagramPacket接受信息
 * 3.处理信息
 * 4.关闭
 */
public class Server04 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10010);
        byte[] bytes = new byte[1024*8];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);//阻塞接受
        System.out.println("数据接受完成");
        System.out.println("数据长度："+packet.getLength());
        String str = new String(bytes,0,packet.getLength());
        System.out.println(str);

    }
}
