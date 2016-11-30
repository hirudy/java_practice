package MyNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author: rudy
 * @date: 2016/11/07
 */
public class DatagramServer {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.bind(new InetSocketAddress("localhost",8888));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        CharBuffer charBuffer = CharBuffer.allocate(100);
        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
        while (true){
            buffer.clear();
            charBuffer.clear();
            SocketAddress remoteAddress = channel.receive(buffer);
            buffer.flip();
            decoder.decode(buffer,charBuffer,false);
            charBuffer.flip();
            System.out.println( remoteAddress +":" + new String(charBuffer.array(),0, charBuffer.limit()));
        }
    }
}
