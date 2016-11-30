package MyAIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author: rudy
 * @date: 2016/11/30
 */
public class SocketServer {

    public static void socketServer() throws Exception {
        final AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel
                .open()
                .bind(new InetSocketAddress("0.0.0.0",8888));
        channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(final AsynchronousSocketChannel client, Void attachment) {
                channel.accept(null, this);

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result_num, ByteBuffer attachment) {
                        attachment.flip();
                        CharBuffer charBuffer = CharBuffer.allocate(1024);
                        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
                        decoder.decode(attachment,charBuffer,false);
                        charBuffer.flip();
                        String data = new String(charBuffer.array(),0, charBuffer.limit());
                        System.out.println("read data:" + data);
                        try{
                            client.close();
                        }catch (Exception e){}
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.println("read error");
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("accept error");
            }
        });

        while (true){
            Thread.sleep(1000);
        }
    }

    @Test(timeout = 60*1000)
    public void testSocketServer() throws Exception{
        socketServer();
    }
}
