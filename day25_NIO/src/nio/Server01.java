package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO网络编程：
 * 1.非阻塞IO
 * 2.基于Selector（选择器）来进行操作，实现IO的多路复用
 *      a.注册选择器到Socket通道
 *      b.监听事件（发送了某些事件，会触发方法调用）
 *      c.获取连接的客户端Socket通道进行读写（操作缓冲区）
 */
public class Server01 {

    public static void main(String[] args) throws IOException {
        //1.开启服务端nio通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.设置非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //3.设置端口
        serverSocketChannel.bind(new InetSocketAddress(10086));
        //4.获取IO多路复用选择器
        Selector selector = Selector.open();

        //5.注册服务端通道，并设置绑定到选择器上的 监听事件 （需要监听什么）
        //SelectionKey：监听事件的key
        //OP_ACCEPT：接受
        //OP_CONNECT：连接
        //OP_WRITE：写
        //  通过 key：channels 绑定
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.遍历获取所有的准备就绪的通道
        while (selector.select()>0){//有就绪的通道
            //获取所有的SelectionKey
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            //找出key对应的准备就绪通道
            while (it.hasNext()){
                SelectionKey key = it.next();
                //isAcceptable():准备就绪
                if(key.isAcceptable()){//接受信息
                    //7.获取到所有已经准备就绪的客户端通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //8.设置非阻塞
                    socketChannel.configureBlocking(false);
                    //9.注册到selector 并且监听就绪
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){//读信息
                    //10.读就绪的操作
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    int len = 0;
                    //11.读写操作
                    while((len=socketChannel.read(buffer))>0){
                        buffer.flip();
                        byte[] array = buffer.array();//获取缓冲区中传递的字节
                        String msg = new String(array,0,len);
                        System.out.println("客户端："+msg);
                        buffer.clear();
                    }
                    //12.操作完成，移除绑定在SelectionKey上的通道
                    it.remove();
                }
            }
            serverSocketChannel.close();
        }
    }
}
