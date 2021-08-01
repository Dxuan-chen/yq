package nio_channel;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *
 */
public class Demo03 {

    @Test
    public void test01(){
        CharBuffer buffer = CharBuffer.allocate(10);
        System.out.println("-------创建完成-------");
        System.out.println(buffer.length());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        buffer.put("A");
        buffer.put("B");
        buffer.put("C");
        System.out.println("当前buffer内容："+buffer);
        System.out.println("-------添加4个元素完成-------");
        System.out.println("剩余可存入长度："+buffer.length());
        System.out.println("最大元素长度："+buffer.limit());
        System.out.println("当前操作位置："+buffer.position());

        //切换到读操作 position会变成0 limit会变成3 可读元素0-1位置
        buffer.flip();
        System.out.println("-------切换到读操作-------");
        System.out.println("剩余可存入长度："+buffer.length());
        System.out.println("最大元素长度："+buffer.limit());
        System.out.println("当前操作位置："+buffer.position());

        //读操作 get():读取出当前待读取元素，且position后移
        //get(i):取出，position不变化
        char c = buffer.get();
        System.out.println("-------读取元素-------");
        System.out.println("剩余可存入长度："+buffer.length());
        System.out.println("最大元素长度："+buffer.limit());
        System.out.println("当前操作位置："+buffer.position());

        char c2 = buffer.get(1);
        System.out.println("-------读取元素-------");
        System.out.println("剩余可存入长度："+buffer.length());
        System.out.println("最大元素长度："+buffer.limit());
        System.out.println("当前操作位置："+buffer.position());

        //切换到写模式 原数据不会删除
        buffer.clear();
        System.out.println("-------切换到写模式-------");
        System.out.println("剩余可存入长度："+buffer.length());
        System.out.println("最大元素长度："+buffer.limit());
        System.out.println("当前操作位置："+buffer.position());

        buffer.put('a');
        buffer.put('b');
        buffer.put(4,'c');
        System.out.println("剩余可存入长度："+buffer.length());
        System.out.println("最大元素长度："+buffer.limit());
        System.out.println("当前操作位置："+buffer.position());
        System.out.println("当前buffer内容："+buffer);
        System.out.println(buffer.get(0));

        buffer.flip();//limit=position
        System.out.println("limit:"+buffer.limit());
        for (int i = 0;i < buffer.limit();i++){
            System.out.println(buffer.get((i)));
        }
    }

    @Test
    public void test02(){
        CharBuffer buffer = CharBuffer.allocate(10);
        char[] chars = "abcdefg".toCharArray();
        buffer.put(chars);
        System.out.println(buffer.position());

        buffer.clear();
        buffer.put("AB");

        System.out.println(buffer.position());
        buffer.mark();

        buffer.reset();
        System.out.println(buffer.position());

        buffer.position(3);
        System.out.println(buffer.position());
    }

    @Test
    public void test03() throws IOException {
        long start = System.currentTimeMillis();
        //1.获取通道对象
        FileInputStream fis = new FileInputStream("D:\\VMware\\新建文件夹\\XP_INSTALL181209.iso");
        FileChannel fisChannel = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("D:\\java\\XP_INSTALL181209.iso");
        FileChannel fosChannel = fos.getChannel();

        //2.操作缓冲区，通过通道传输数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(fisChannel.read(buffer)!=-1){
            //buffer转换成读操作
            buffer.flip();
            fosChannel.write(buffer);
            buffer.clear();//切换到写模式
        }
        //3.关闭资源
        fosChannel.close();
        fos.close();
        fisChannel.close();
        fis.close();
        long end = System.currentTimeMillis();
        long totalSeconds = (end-start)/1000;
        long currentMinute = totalSeconds/60;
        System.out.println("复制完成，耗时："+currentMinute%60+"min "+totalSeconds+"s");
    }

    @Test
    public void test04(){
        System.out.println("是否是直接缓冲区："+ByteBuffer.allocate(1024).isDirect());
        System.out.println("是否是直接缓冲区："+ByteBuffer.allocateDirect(1024).isDirect());

    }

    @Test
    public void test05() throws IOException {
        long start = System.currentTimeMillis();

        //获取通道
        FileChannel openChannel = FileChannel.open(Path.of("D:\\VMware\\新建文件夹\\XP_INSTALL181209.iso"), StandardOpenOption.READ);
        //NonWritableChannelException:必须设置读权限
        FileChannel writeChannel = FileChannel.open(Path.of("D:\\java\\XP_INSTALL181209.iso"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //获取物理内存映射
        //MapMode mode, Long position, long size:  内存映射模式，开始读取位置，长度
        //map会映射操作生成缓冲区对象
        MappedByteBuffer inMap = openChannel.map(FileChannel.MapMode.READ_ONLY,0,openChannel.size());
        MappedByteBuffer outMap  = writeChannel.map(FileChannel.MapMode.READ_WRITE,0,openChannel.size());
        //创建一个用来映射传输数组
        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.get(bytes);
        long end = System.currentTimeMillis();
        long totalSeconds = (end-start)/1000;
        long currentMinute = totalSeconds/60;
        System.out.println("复制完成，耗时："+currentMinute%60+"min "+totalSeconds+"s");

    }

    @Test
    public void test06() throws IOException {
        long start = System.currentTimeMillis();

        Files.copy(Path.of("D:\\VMware\\新建文件夹\\XP_INSTALL181209.iso"),new FileOutputStream("D:\\java\\XP_INSTALL181209.iso"));
        long end = System.currentTimeMillis();
        long totalSeconds = (end-start)/1000;
        long currentMinute = totalSeconds/60;

        System.out.println("复制完成，耗时："+currentMinute%60+"min "+totalSeconds+"s");
    }
}
