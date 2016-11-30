package MyAIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * @author: rudy
 * @date: 2016/11/30
 */
public class SocketClient {

    public static void socketClient() throws Exception {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1",8888)).get();
        ByteBuffer buffer = ByteBuffer.wrap("中文,你好".getBytes());
        Future<Integer> future = channel.write(buffer);

        future.get();
        System.out.println("send ok");
    }


    @Test
    public void testSocketClient() throws Exception{
        socketClient();
    }
}
