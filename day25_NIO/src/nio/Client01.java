package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Client01 {
    public static void main(String[] args) throws IOException {
        //1.创建客户端通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(10086));
        //2.设置非阻塞
        channel.configureBlocking(false);

        //3.置缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String msg = "你好服务器";
        //放入数据到缓冲区
        buffer.put(msg.getBytes());
        //切换到读模式
        buffer.flip();
        //将数据读取到通道写出
        channel.write(buffer);
        buffer.clear();

        channel.close();

    }
}
