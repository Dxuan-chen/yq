package udp;

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
public class Client04 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "喜马拉雅".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10010);

        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
        socket.close();
    }
}
